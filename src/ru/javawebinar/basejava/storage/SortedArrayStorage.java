package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {
        int index = getIndex(r);
    }

    @Override
    public void delete(String uuid) {

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
}
