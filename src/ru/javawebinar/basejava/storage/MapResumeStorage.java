package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
    Map<String, Resume> storage = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void doSave(Resume r, Resume resume) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume resume) {
        return (Resume) resume;
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Resume resume) {
        storage.remove(((Resume) resume).getUuid());
    }

    @Override
    protected boolean isExisting(Resume resume) {
        return resume != null;
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
