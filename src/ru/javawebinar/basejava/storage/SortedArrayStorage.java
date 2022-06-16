package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage  extends AbstractArrayStorage {

    @Override
    protected void insertResume(Resume r, int index) {
        int insertIndex = - index - 1;
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
        storage[insertIndex] = r;
    }

    @Override
    protected void deleteResume(int index) {
        int elementAmount = size - index - 1;
        System.arraycopy(storage, index + 1, storage, index, elementAmount);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
