package com.library.service.Impl;

import com.library.model.Author;
import com.library.model.Enums.BookStatus;
import com.library.model.Book;
import com.library.model.Enums.Genre;
import com.library.model.Person;
import com.library.model.User;
import com.library.service.LibraryService;
import com.library.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private LibraryService libraryService;

    @Override
    public void addBooks() {
        System.out.println("\nAdding books");
        libraryService.addBook("Song of Solomon", new Author(new Person("Toni", "Morrison")), Genre.CLASSIC);
        libraryService.addBook("War and Peace", new Author(new Person("Leo", "Tolstoy")), Genre.CLASSIC);
        libraryService.addBook("The Lord of the Rings", new Author(new Person("John", "Ronald Reuel", "Tolkien")), Genre.FANTASY);
        libraryService.addBook("The Lord of the Rings", new Author(new Person("John", "Ronald Reuel", "Tolkien")), Genre.FANTASY);
        libraryService.addBook("Don Quixote", new Author(new Person("Miguel", "De Cervantes")), Genre.HISTORICAL);
    }

    @Override
    public void addUsers() {
        System.out.println("\nAdding users");
        libraryService.addUser(new Person("Ivan", "Ivanov"));
        libraryService.addUser(new Person("Petr", "Petrovich", "Petov"));
        libraryService.addUser(new Person("Vasya", "Pupkin"), true);
        libraryService.addUser(new Person("Sidor", "Sidorovich", "Sidorov"));
        libraryService.addUser(new Person("Alexandr", "Malykh"));
    }

    @Override
    public void setBookStatus() {
        System.out.println("\nSet book status with id=1 to READING_ROOM");
        libraryService.setBookStatus(1, BookStatus.READING_ROOM);

        System.out.println("\nSet book  'War and Peace' status to READING_ROOM");
        Book book = libraryService.getBookDAO().getByName("War and Peace").get(0);
        libraryService.setBookStatus(book.getId(), BookStatus.READING_ROOM);
    }

    @Override
    public void setUserAsDebtor() {
        System.out.println("\nSet user with name Sidor Sidorov as debtor");
        User user = libraryService.getUserDAO().getByShortName("Sidor", "Sidorov");
        libraryService.setUserAsDebtor(user.getId());
    }

    @Override
    public void setBookGenre() {
        System.out.println("\nSet book genre with id =1 to COOK_BOOK");
        libraryService.setBookGenre(1, Genre.COOK_BOOK);
    }

    @Override
    public void deleteBook() {
        System.out.println("\ndeleting book with id=1");
        libraryService.getBookDAO().delete(1);
    }

    @Override
    public void printAuthors() {
        System.out.println("\nPrint all authors");
        libraryService.getAuthorDAO().getAll().forEach(System.out::println);
    }

    @Override
    public void printBooks() {
        System.out.println("\nPrint all books");
        libraryService.getBookDAO().getAll().forEach(System.out::println);
    }

    @Override
    public void printUsers() {
        System.out.println("\nPrint all users");
        libraryService.getUserDAO().getAll().forEach(System.out::println);
    }

    @Override
    public void setUserAsLibrarian() {
        System.out.println("\nSet user 'Petr Petrovich Petov' as librarian");
        User user = libraryService.getUserDAO().getByPerson(new Person("Petr", "Petrovich", "Petov"));
        libraryService.setUserAsLibrarian(user.getId());
    }
}
