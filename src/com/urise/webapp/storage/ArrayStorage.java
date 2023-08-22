package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage,0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (findResume(r) < 0) {
            storage[size++] = r;
            return;
        }
        System.out.println("ERROR: resume is already present");
    }

    public void update(Resume resume) {
        int idx = findResume(resume);
        if (idx >= 0) {
            storage[idx] = resume;
        } else {
            System.out.println("ERROR: resume is absent");
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        System.out.println("ERROR: resume is absent");
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                size--;
                storage[i] = storage[size];
                storage[size] = null;
                return;
            }
        }
        System.out.println("ERROR: resume is absent");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int findResume(Resume r) {
        for (int i = 0; i < size; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
