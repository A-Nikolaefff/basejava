package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage  extends AbstractArrayStorage {

    @Override
    protected void insert(Resume r, int index) {
        int insertIndex = - index - 1;
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
        storage[insertIndex] = r;
    }

    @Override
    protected void remove(int index) {
        int elementAmount = size - index - 1;
        if (elementAmount > 0) {
            System.arraycopy(storage, index + 1, storage, index, elementAmount);
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
