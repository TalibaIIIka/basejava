package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> resumes = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, String uuid) {
        resumes.put(uuid, r);
    }

    @Override
    protected boolean isExist(String uuid) {
        return resumes.containsKey(uuid);
    }

    @Override
    protected void doSave(Resume r, String uuid) {
        resumes.put(uuid, r);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return resumes.get(searchKey);
    }

    @Override
    protected void doDelete(String searchKey) {
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
