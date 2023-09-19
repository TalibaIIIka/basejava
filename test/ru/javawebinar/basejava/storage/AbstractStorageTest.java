package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class AbstractStorageTest {
    protected final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1 = new Resume(UUID_1, "Name_1");
    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2 = new Resume(UUID_2, "Name_2");
    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3 = new Resume(UUID_3, "Name_3");
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_4 = new Resume(UUID_4, "Name_4");

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    void size() {
        assertSize(3);
    }

    @Test
    void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    void update() {
        Resume newResume = new Resume(UUID_1, "Updated");
        storage.update(newResume);
        assertSame(newResume, storage.get(UUID_1));
    }

    @Test
    void updateNotExist() throws Exception {
        Assertions.assertThrows(NotExistStorageException.class,
                () -> storage.get("dummy"));
    }

    @Test
    void getAll() {
        Resume[] array = storage.getAll();
        assertEquals(3, array.length);
        assertEquals(RESUME_1, array[0]);
        assertEquals(RESUME_2, array[1]);
        assertEquals(RESUME_3, array[2]);
    }

    @Test
    void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test
    void delete() {
        storage.delete(UUID_1);
        assertSize(2);
        Assertions.assertThrows(NotExistStorageException.class,
                () -> storage.get(UUID_1));
    }

    @Test
    void deleteNotExist() {
        Assertions.assertThrows(NotExistStorageException.class,
                () -> storage.delete("dummy"));
    }

    @Test
    void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test
    void getNotExist() throws Exception {
        Assertions.assertThrows(NotExistStorageException.class, () -> {
            storage.get("dummy");
        });
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}