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
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume targetResume = new Resume(uuid);
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).equals(targetResume)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume doGet(int index) {
        return storage.get(index);
    }

    @Override
    protected void doSave(Resume r, int index) {
        storage.add(r);
    }

    @Override
    public void doUpdate(Resume r, int index) {
        storage.set(index, r);
    }

    @Override
    protected void doDelete(int index) {
        storage.remove(index);
    }
}
