package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract int getIndex(String uuid);

    protected abstract void doSave(Resume r, int index);

    protected abstract Resume doGet(int index);

    protected abstract void doUpdate(Resume r, int index);

    protected abstract void doDelete(int index);

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return doGet(index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else {
            doSave(r, index);
        }
    }

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            doUpdate(r, index);
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            doDelete(index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }
}
