package com.example.snippets.files;

public class File {

    private String name;
    private long size;
    private Group collection;

    public File(String name, long size, Group collection) {
        this.name = name;
        this.size = size;
        this.collection = collection;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public Group getCollection() {
        return collection;
    }
}
