package com.library.DAO;

import com.library.model.Book;
import com.library.model.Enums.BookStatus;
import com.library.model.Enums.Genre;

import java.util.List;

public interface BookDAO extends BasicDAO<Book> {

    List<Book> getByName(String name);

    List<Book> getByGenre(Genre genre);

    List<Book> getByStatus(BookStatus status);

    Genre setGenre(long id, Genre genre);
}
