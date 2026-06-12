package com.example.blog_app;

public class Blog {
    private final long id;
    private final String title;

    private final String notes;

    public Blog(long id, String title, String notes) {
        this.id = id;
        this.title = title;
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNotes() {
        return notes;
    }

}
