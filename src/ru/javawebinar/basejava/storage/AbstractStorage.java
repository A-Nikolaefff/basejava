package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getSearchKey(String uuid);

    protected abstract void doSave(Resume r, Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doUpdate(Resume r, Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract boolean isExisting(Object searchKey);

    protected abstract List<Resume> doCopy();

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = doCopy();
        list.sort(Comparator.comparing((Resume resume) -> resume.getFullName()).thenComparing(resume -> resume.getUuid()));
        return list;
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getExistingKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public void save(Resume r) {
        Object searchKey = getNotExistingKey(r.getUuid());
        doSave(r, searchKey);
    }

    @Override
    public void update(Resume r) {
        Object searchKey = getExistingKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getExistingKey(uuid);
        doDelete(searchKey);
    }

    private Object getExistingKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExisting(searchKey)) {
            return searchKey;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private Object getNotExistingKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExisting(searchKey)) {
            return searchKey;
        } else {
            throw new ExistStorageException(uuid);
        }
    }
}
