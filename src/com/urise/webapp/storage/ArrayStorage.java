package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size - 1, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size == storage.length) {
            System.out.println("The storage is completely full.");
            return;
        }
        if (findIndex(r.getUuid()) != -1) {
            System.out.println("Resume \"" + r.getUuid() + "\" already exists.");
            return;
        }
        storage[size] = r;
        size++;
    }

    public void update(Resume r) {
        String uuid = r.getUuid();
        int index = findIndex(uuid);
        if (index == -1) {
            System.out.println("Cannot update resume \"" + uuid + "\" because resume \"" + uuid + "\" does not exist.");
            return;
        }
        storage[index] = r;
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
        System.out.println("Cannot get resume \"" + uuid + "\" because resume \"" + uuid + "\" does not exist.");
        return null;
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            return;
        }
        System.out.println("Cannot delete resume \"" + uuid + "\" because resume \"" + uuid + "\" does not exist.");
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
