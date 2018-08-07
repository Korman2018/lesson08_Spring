package com.library.model.Enums;

public enum Genre {
    CRIME("CRIME"),
    DETECTIVE("DETECTIVE"),
    SCIENCE("SCIENCE"),
    FANTASY("FANTASY"),
    HORROR("HORROR"),
    CLASSIC("CLASSIC"),
    FAIRY_TALE("FAIRY_TALE"),
    HISTORICAL("HISTORICAL"),
    HUMOR("HUMOR"),
    GUIDE("GUIDE"),
    REFERENCE_BOOK("REFERENCE_BOOK"),
    ENCYCLOPEDIA("ENCYCLOPEDIA"),
    DICTIONARY("DICTIONARY"),
    TECHNICAL_BOOK("TECHNICAL_BOOK"),
    COOK_BOOK("COOK_BOOK"),
    OTHER("OTHER"),
    SEVERAL("SEVERAL"),
    UNKNOWN("UNKNOWN");

    private String description;

    Genre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Genre getByName(String name) {
        return valueOf(name);
    }

    @Override
    public String toString() {
        return description;
    }
}
