package com.library.service.Impl;

import com.library.DAO.AuthorDAO;
import com.library.DAO.BookDAO;
import com.library.DAO.UserDAO;
import com.library.model.*;
import com.library.model.Enums.BookStatus;
import com.library.model.Enums.Genre;
import com.library.model.Author;
import com.library.model.Book;
import com.library.model.User;
import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private AuthorDAO authorDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public long addBook(String bookName, Author author, Genre genre) {

        Author findAuthors = authorDAO.getByPerson(author.getPerson());
        long authorId;

        // если автора нет в базе, то создаем нового
        if (findAuthors == null) {
            authorId = authorDAO.add(author);
        } else {
            authorId = findAuthors.getId();
        }

        return bookDAO.add(new Book(bookName, authorId, genre));
    }

    @Override
    public long addBook(String bookName, Author author) {
        return addBook(bookName, author, Genre.UNKNOWN);
    }

    @Override
    public long addUser(Person person, boolean isLibrarian) {
        return userDAO.add(new User(person, isLibrarian));
    }


    @Override
    public long addUser(Person person) {
        return addUser(person, false);
    }

    @Override
    public BookStatus setBookStatus(long id, BookStatus status) {
        Book book = bookDAO.getById(id);
        book.setStatus(status);
        return bookDAO.set(book).getStatus();
    }

    @Override
    public Book deleteBook(long id) {
        return bookDAO.delete(id);
    }

    @Override
    public boolean setUserAsDebtor(long id) {
        User user = userDAO.getById(id);
        boolean oldStatus = user.getIsDebtor();

        user.setIsDebtor(true);
        userDAO.set(user);
        return oldStatus;
    }

    @Override
    public boolean setUserAsLibrarian(long id) {
        User user = userDAO.getById(id);
        boolean oldStatus = user.getIsLibrarian();

        user.setIsLibrarian(true);
        userDAO.set(user);
        return oldStatus;
    }

    @Override
    public Genre setBookGenre(long id, Genre genre) {
        return bookDAO.setGenre(id, genre);
    }

    @Override
    public BookDAO getBookDAO() {
        return bookDAO;
    }

    @Override
    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    @Override
    public UserDAO getUserDAO() {
        return userDAO;
    }
}
