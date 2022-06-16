package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract SK getSearchKey(String uuid);

    protected abstract void doSave(Resume r, SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doUpdate(Resume r, SK searchKey);

    protected abstract void doDelete(SK searchKey);

    protected abstract boolean isExisting(SK searchKey);

    protected abstract List<Resume> doCopy();

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> list = doCopy();
        list.sort(Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid));
        return list;
    }

    @Override
    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = getExistingKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public void save(Resume r) {
        LOG.info("Save " + r);
        SK searchKey = getNotExistingKey(r.getUuid());
        doSave(r, searchKey);
    }

    @Override
    public void update(Resume r) {
        LOG.info("Update " + r);
        SK searchKey = getExistingKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = getExistingKey(uuid);
        doDelete(searchKey);
    }

    private SK getExistingKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExisting(searchKey)) {
            return searchKey;
        } else {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
    }

    private SK getNotExistingKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExisting(searchKey)) {
            return searchKey;
        } else {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
    }
}
