package ru.javawebinar.basejava.model;

import java.util.Objects;

public class ContentSection extends Section {
    private final String content;

    public ContentSection(String content) {
        Objects.requireNonNull(content, "Content must not be null");
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContentSection that = (ContentSection) o;

        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}
