package org.ua.bryl.services.implementation;

import org.ua.bryl.dao.Dao_Book;
import org.ua.bryl.model.Book;
import org.ua.bryl.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by olegbryl 13/08/2018.
 */
@Service
public class BookServiceImp implements BookService {

    @Autowired
    private Dao_Book dao_book;

    public List<Book> getBookList() {
        return dao_book.getBookList();
    }

    public Book getBookById(int id) {
        return dao_book.getBookById(id);
    }

    public void addBook(Book book) {
        dao_book.addBook(book);
    }

    public void editBook(Book book) {
        dao_book.editBook(book);
    }

    public void deleteBook(Book book) {
        dao_book.deleteBook(book);
    }
}
