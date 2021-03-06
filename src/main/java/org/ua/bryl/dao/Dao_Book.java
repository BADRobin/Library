package org.ua.bryl.dao;

import org.ua.bryl.model.Book;

import java.util.List;
/**
 * Created by olegbryl 18/03/2019.
 */

public interface Dao_Book {

    List<Book> getBookList();

    Book getBookById(int book_id);

    void addBook(Book book);

    void editBook(Book book);

    void deleteBook(Book book);
}
