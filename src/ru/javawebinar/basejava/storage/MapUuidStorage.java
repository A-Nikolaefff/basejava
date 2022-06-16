package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {
    Map<String, Resume> storage = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doSave(Resume r, String searchKey) {
        storage.put((String) searchKey, r);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return storage.get((String) searchKey);
    }

    @Override
    protected void doUpdate(Resume r, String searchKey) {
        storage.put((String) searchKey, r);
    }

    @Override
    protected void doDelete(String searchKey) {
        storage.remove((String) searchKey);
    }

    @Override
    protected boolean isExisting(String searchKey) {
        return storage.containsKey((String) searchKey);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected List<Resume> doCopy() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public int size() {
        return storage.size();
    }
}
