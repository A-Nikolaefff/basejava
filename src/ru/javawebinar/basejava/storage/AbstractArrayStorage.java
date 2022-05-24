package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract int doFindIndex(String uuid);

    protected abstract void doInsert(Resume r, int index);

    protected abstract void doErase(int index);

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    protected int getIndex(String uuid) {
        return doFindIndex(uuid);
    }

    @Override
    protected Resume doGet(int index) {
        return storage[index];
    }

    @Override
    protected void doSave(Resume r, int index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            doInsert(r, index);
            size++;
        }
    }

    @Override
    protected void doUpdate(Resume r, int index) {
        storage[index] = r;
    }

    @Override
    protected void doDelete(int index) {
        doErase(index);
        size--;
    }
}
