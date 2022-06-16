package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract void insertResume(Resume r, int index);

    protected abstract void deleteResume(int index);

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected List<Resume> doCopy() {
        return new ArrayList<>(Arrays.asList(Arrays.copyOfRange(storage, 0, size)));
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storage[(int) searchKey];
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertResume(r, (int) searchKey);
            size++;
        }
    }

    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        storage[(int) searchKey] = r;
    }

    @Override
    protected void doDelete(Integer searchKey) {
        deleteResume((int) searchKey);
        size--;
    }

    @Override
    protected boolean isExisting(Integer searchKey) {
        return (int) searchKey >= 0;
    }
}
