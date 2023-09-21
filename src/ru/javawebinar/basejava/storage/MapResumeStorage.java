package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {
    private final Map<String, Resume> resumes = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return resumes.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Object resume) {
        resumes.put(r.getUuid(), (Resume) resume);
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
    }

    @Override
    protected void doSave(Resume r, Object resume) {
        resumes.put(r.getUuid(), (Resume) resume);
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected void doDelete(Object resume) {
        resumes.remove(((Resume) resume).getUuid());
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(resumes.values());
    }

    @Override
    public void clear() {
        resumes.clear();
    }

    @Override
    public int size() {
        return resumes.size();
    }
}
