package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/list")
    public ModelAndView showBooks() {
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/books/{id}")
    public ModelAndView viewBook(@PathVariable("id") Long id) {
       Optional<Book> book= bookService.findById(id);
        if (book == null) {
            return new ModelAndView("book/error");
        }
        ModelAndView modelAndView = new ModelAndView("book/view");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @GetMapping("/borrow/{id}")
    public ModelAndView borrowBook(@PathVariable Long id) {
       Book book = bookService.findById(id);
        if (book == null) {
            return new ModelAndView("book/error");
        }
        book.setQuantity(book.getQuantity() -1);
        if (book.getQuantity() < 0) {
            return new ModelAndView("book/error");
        }
        bookService.save(book);
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/get/{id}")
    public ModelAndView getBook(@PathVariable Long id) {
        Book book = bookService.findById(id);
        if (book == null) {
            return new ModelAndView("book/error");
        }
        book.setQuantity(book.getQuantity() +1);
        bookService.save(book);
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }
}
