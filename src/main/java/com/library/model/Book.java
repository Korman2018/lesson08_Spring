package com.library.model;

import com.library.model.Enums.BookStatus;
import com.library.model.Enums.Genre;

public class Book extends Entity {

    private String bookName;

    private long authorId;

    private Genre genre;

    private BookStatus status;


    public Book(String bookName, long authorId, Genre genre) {
        this.bookName = bookName;
        this.authorId = authorId;
        this.genre = genre;
        status = BookStatus.LIBRARY;
    }


    public Book(String bookName, long authorId) {
        this(bookName, authorId, Genre.UNKNOWN);
    }

    // id = 0 unknown Author
    public Book(String bookName) {
        this(bookName, 0);
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\"");

        stringBuilder.append(getId()).append(". ").append(bookName).append("\" authorId:\"").append(authorId)
                .append("\" book genre:\"").append(genre).append("\" status:\"").append(status).append("\"");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            if (book.getId() == getId()) {
                return true;
            }

            if (!(bookName != null && bookName.equals(book.bookName))) {
                return false;
            }
            return getAuthorId() == book.getAuthorId();
        }
        return false;
    }
}

