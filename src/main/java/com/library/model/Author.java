package com.library.model;

public class Author extends AbstractPersonContainer {


    public Author(Person person) {
        super(person);
    }

    public Author() {
        super(new Person());
        // id = 0 unknown Author
        setId(0);
    }

    @Override
    public String toString() {
        return getId() + ". " + getPerson();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Author) {
            Author author = (Author) obj;
            return getPerson().equals(author.getPerson());
        }
        return false;
    }
}
