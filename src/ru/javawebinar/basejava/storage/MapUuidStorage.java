package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {
    private Map<String, Resume> resumes = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, Object uuid) {
        resumes.put((String) uuid, r);
    }

    @Override
    protected boolean isExist(Object uuid) {
        return resumes.containsKey(uuid);
    }

    @Override
    protected void doSave(Resume r, Object uuid) {
        resumes.put((String) uuid, r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return resumes.get(searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        resumes.remove(searchKey);
    }

    @Override
    public void clear() {
        resumes.clear();
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(resumes.values());
    }

    @Override
    public int size() {
        return resumes.size();
    }
}
