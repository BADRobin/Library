package org.ua.bryl.services;

import org.ua.bryl.model.Book;

import java.util.List;

/**
 * Created by olegbryl 13/08/2018.
 */
public interface BookService {

    List<Book> getBookList();

    Book getBookById(int id);

    void addBook(Book book);

    void editBook(Book book);

    void deleteBook(Book book);

}
