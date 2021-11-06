package com.codegym.service;

import com.codegym.model.Book;

import java.util.Optional;


public interface IBookService {
    Iterable<Book> findAll();

    Optional<Book> findById(Long id);

    void save(Book book);
}
