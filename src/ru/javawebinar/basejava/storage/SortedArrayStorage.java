package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    public void save(Resume r) {
        int index = getIndex(r);
        if (index >= 0) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            save(r, Math.abs(index));
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " doesn't exist");
        } else {
            for (int i = index; i < size; i++) {
                storage[i] = storage[i+1];
            }
            size--;
            storage[size] = null;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return getIndex(searchKey);
    }

    protected int getIndex(Resume r) {
        return Arrays.binarySearch(storage, 0, size, r);
    }

    private void save(Resume r, int index) {
        for (int i = size; i >= index; i--) {
            storage[i] = storage[i-1];
        }
        storage[index - 1] = r;
    }
}
