package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    protected int getSearchKey(String uuid) {
        Resume targetResume = new Resume(uuid);
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).equals(targetResume)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get((int) searchKey);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        storage.add(r);
    }

    @Override
    public void doUpdate(Resume r, Object searchKey) {
        storage.set((Integer) searchKey, r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove((int) searchKey);
    }

    @Override
    protected boolean isExisting(Object searchKey) {
        return (int) searchKey >= 0;
    }
}
