package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.ResumeTestData;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.List;

public abstract class AbstractStorageTest {
    protected final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    public static final String UUID_NOT_EXIST = "dummy";

    public static final Resume RESUME_1 = ResumeTestData.getTestResume(UUID_1, "resume 1");
    public static final Resume RESUME_2 = ResumeTestData.getTestResume(UUID_2, "resume 2");
    public static final Resume RESUME_3 = ResumeTestData.getTestResume(UUID_3, "resume 3");
    public static final Resume RESUME_4 = ResumeTestData.getTestResume(UUID_4, "resume 4");

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);

        Resume[] expected = new Resume[0];
        List<Resume> received = storage.getAllSorted();
        Assert.assertArrayEquals(expected, received.toArray());
    }

    @Test
    public void getAll() {
        assertSize(3);
        Resume[] expected = new Resume[]{RESUME_1, RESUME_2, RESUME_3};
        List<Resume> received = storage.getAllSorted();
        Assert.assertArrayEquals(expected, received.toArray());
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test
    public void update() {
        Resume resume = new Resume(UUID_1, "resume 1");
        storage.update(resume);
        assertGet(resume);
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertGet(RESUME_4);
        assertSize(4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        assertSize(2);
        storage.delete(UUID_4);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_NOT_EXIST);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws NotExistStorageException {
        storage.get(UUID_NOT_EXIST);
    }

    private void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }
}