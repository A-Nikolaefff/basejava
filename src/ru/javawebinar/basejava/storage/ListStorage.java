package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
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
    protected Integer getSearchKey(String uuid) {
        Resume targetResume = new Resume(uuid, "dummy");
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).equals(targetResume)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storage.get((int) searchKey);
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        storage.add(r);
    }

    @Override
    public void doUpdate(Resume r, Integer searchKey) {
        storage.set((Integer) searchKey, r);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        storage.remove((int) searchKey);
    }

    @Override
    protected boolean isExisting(Integer searchKey) {
        return (int) searchKey >= 0;
    }

    @Override
    protected List<Resume> doCopy() {
        return new ArrayList<Resume>(storage);
    }
}
