package ru.javawebinar.basejava.model;

import java.io.Serializable;
import java.util.Objects;

public class ContentSection extends Section implements Serializable {
    private static final long serialVersionUID = 1L;
    private String content;

    public ContentSection() {
    }

    public ContentSection(String content) {
        Objects.requireNonNull(content, "Content must not be null");
        this.content = content;
    }

    public String getContent() {
        return content;
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
