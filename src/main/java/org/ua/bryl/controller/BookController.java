package org.ua.bryl.controller;

import org.ua.bryl.model.Book;
import org.ua.bryl.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
/**
 * Created by olegbryl 01/08/2018.
 */

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping
    public String getBook(Model model) {
        List<Book> list_books = bookService.getBookList();
        model.addAttribute("list_books", list_books);
        return "book";
    }

    @RequestMapping("/BookDetails/{book_id}")
    public String detailsBook(@PathVariable int book_id, Model model) throws IOException {
        Book book = bookService.getBookById(book_id);
        model.addAttribute(book);

        return "pookDetails";
    }
}
