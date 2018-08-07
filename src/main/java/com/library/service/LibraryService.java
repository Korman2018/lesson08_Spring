package com.library.service;

import com.library.DAO.AuthorDAO;
import com.library.DAO.BookDAO;
import com.library.DAO.UserDAO;
import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Enums.BookStatus;
import com.library.model.Enums.Genre;
import com.library.model.Person;

public interface LibraryService {

    long addBook(String bookName, Author author, Genre genre);

    long addBook(String bookName, Author author);

    long addUser(Person person, boolean isLibrarian);

    long addUser(Person person);

    BookStatus setBookStatus(long id, BookStatus status);

    Book deleteBook(long id);

    boolean setUserAsDebtor(long id);

    boolean setUserAsLibrarian(long id);

    Genre setBookGenre(long id, Genre genre);

    BookDAO getBookDAO();

    AuthorDAO getAuthorDAO();

    UserDAO getUserDAO();
}
