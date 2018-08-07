package com.library.DAO.Impl;

import com.library.DAO.BookDAO;
import com.library.model.Book;
import com.library.model.Enums.BookStatus;
import com.library.model.Enums.Genre;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDAOImpl extends AbstractDAO<Book> implements BookDAO {

    @Override
    public List<Book> getByName(String name) {
        List<Book> books = new ArrayList<>();

        if (name != null) {
            for (Book book : getAll()) {
                if (name.equalsIgnoreCase(book.getBookName())) {
                    books.add(book);
                }
            }
            return books;
        }
        return new ArrayList<>();
    }


    @Override
    public List<Book> getByGenre(Genre genre) {
        List<Book> books = new ArrayList<>();

        for (Book book : getAll()) {
            if (genre.equals(book.getGenre())) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> getByStatus(BookStatus status) {
        List<Book> books = new ArrayList<>();

        for (Book book : getAll()) {
            if (status.equals(book.getStatus())) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public Genre setGenre(long id, Genre genre) {
        Book book = getById(id);
        Genre oldGenre = book.getGenre();

        book.setGenre(genre);
        return oldGenre;
    }
}
