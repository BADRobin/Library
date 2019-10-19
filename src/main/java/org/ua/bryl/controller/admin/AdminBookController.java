package org.ua.bryl.controller.admin;


import org.springframework.web.bind.annotation.*;

import org.ua.bryl.model.Book;
import org.ua.bryl.services.BookService;
import org.ua.bryl.utils.Book_Category_List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



/**
 * Created by olegbryl 18/03/2019.
 */

@Controller
@RequestMapping("/admin")
public class AdminBookController {



    private Path image;
    private Path file;
//    Path image = Paths.get(root_directory + "\\WEB-INF\\resources\\book_images\\" + book.getBook_id() + ".png");
    private Book_Category_List list_categories = new Book_Category_List();
    @Autowired
    private BookService bookService;



    @RequestMapping("/inventory/add")
    public String BookAdd(Model model) {
        Book book = new Book();

        model.addAttribute("category_list", list_categories.categories);
        model.addAttribute(book);

        return "bookAdd";
    }

    @RequestMapping(value = "/inventory/add" , method = RequestMethod.POST)
    public String addBookPost(@Valid @ModelAttribute("book") Book book,
                                 BindingResult result, HttpServletRequest request, Model model) {
        model.addAttribute("category_list", list_categories.categories);

        if(result.hasErrors()) {
            return "bookAdd";
        }
        bookService.addBook(book);
        MultipartFile book_image = book.getImage();
        MultipartFile book_bookFile = book.getBookFile();
        String root_directory = request.getSession().getServletContext().getRealPath("/");
        image = Paths.get(root_directory + "\\WEB-INF\\resources\\book_images\\" + book.getBook_id() + ".png");
        file = Paths.get(root_directory + "\\WEB-INF\\resources\\book_files\\" + book.getBook_id() + ".txt");
        if (book_image != null && !book_image.isEmpty()) {
            try {
                book_image.transferTo(new File(image.toString()));

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("The book image could not be saved.\n" + e);
            }
        }if (book_bookFile != null && !book_bookFile.isEmpty()){
            try {
                book_bookFile.transferTo(new File(file.toString()));

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("The book file could not be saved.\n" + e);
            }
        }
        return "redirect:/admin/inventory";
    }

    @RequestMapping("/inventory/edit/{book_id}")
    public String editBook(@PathVariable("book_id") int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("category_list", list_categories.categories);
        model.addAttribute("book", book);

        return "bookEdit";
    }

    @RequestMapping(value = "/inventory/edit", method = RequestMethod.POST)
    public String editBookPost(@Valid @ModelAttribute("book") Book book,
                                  BindingResult result, Model model, HttpServletRequest request) throws RuntimeException {
        model.addAttribute("category_list", list_categories.categories);
        if (result.hasErrors()) {
            return "bookEdit";
        }
        MultipartFile bookImage = book.getImage();
        MultipartFile bookFile = book.getBookFile();
        String root_directory = request.getSession().getServletContext().getRealPath("/");
        image = Paths.get(root_directory + "\\WEB-INF\\resources\\book_images\\" + book.getBook_id() + ".png");
        file = Paths.get(root_directory + "\\WEB-INF\\resources\\book_files\\" + book.getBook_id() + ".txt");

        if (bookImage != null && !bookImage.isEmpty()) {
                try {
                    bookImage.transferTo(new File(image.toString()));
                } catch (Exception e) {
                    throw new RuntimeException("The book image could not be saved.\n" + e);
                }
        }if(bookFile != null && !bookFile.isEmpty()){
            try {
                bookFile.transferTo(new File(file.toString()));
            } catch (Exception e) {
                throw new RuntimeException("The book file could not be saved.\n" + e);
            }
        }
        bookService.editBook(book);

        return "redirect:/admin/inventory";
    }

    @RequestMapping("/inventory/remove/{book_id}")
    public String deleteBook(@PathVariable("book_id") int book_id, Model model, HttpServletRequest request) {
        String root_directory = request.getSession().getServletContext().getRealPath("/");
        image = Paths.get(root_directory + "\\WEB-INF\\resources\\book_images\\" + book_id + ".png");
        file = Paths.get(root_directory + "\\WEB-INF\\resources\\book_files\\" + book_id + ".txt");
        if (Files.exists(image) & Files.exists(file)) {
            try {
                Files.delete(image);
                Files.delete(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Book book = bookService.getBookById(book_id);
        bookService.deleteBook(book);

        return "redirect:/admin/inventory";
    }

}
