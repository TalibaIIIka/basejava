package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage<Resume> {
    private final Map<String, Resume> resumes = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return resumes.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        resumes.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    @Override
    protected void doSave(Resume r, Resume resume) {
        resumes.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume resume) {
        return resume;
    }

    @Override
    protected void doDelete(Resume resume) {
        resumes.remove(resume.getUuid());
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
