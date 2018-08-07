package com.library.model.Enums;

public enum BookStatus {
    READING_ROOM("READING_ROOM"),
    SUBSCRIPTION("SUBSCRIPTION"),
    LIBRARY("LIBRARY");

    private String description;

    BookStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
