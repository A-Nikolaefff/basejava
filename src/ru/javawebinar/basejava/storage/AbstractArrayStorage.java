package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

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

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Cannot get resume \"" + uuid + "\" because resume \"" + uuid + "\" does not exist.");
            return null;
        }
        return storage[index];
    }

    public void update(Resume r) {
        String uuid = r.getUuid();
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Cannot update resume \"" + uuid + "\" because resume \"" + uuid + "\" does not exist.");
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = findIndex(r.getUuid());
        if (index >= 0) {
            System.out.println("Resume \"" + r.getUuid() + "\" already exists.");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("The storage is completely full.");
        } else {
            insertElement(r, index);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Cannot delete resume \"" + uuid + "\" because resume \"" + uuid + "\" does not exist.");
        } else {
            removeElement(index);
            size--;
        }
    }

    protected abstract int findIndex(String uuid);

    protected abstract void insertElement(Resume r, int index);

    protected abstract void removeElement(int index);
}
