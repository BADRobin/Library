package org.ua.bryl.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import org.ua.bryl.model.Book;

import java.util.List;
import java.util.Optional;

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
