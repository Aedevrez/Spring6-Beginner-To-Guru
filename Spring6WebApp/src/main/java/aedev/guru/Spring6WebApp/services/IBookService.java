package aedev.guru.Spring6WebApp.services;

import aedev.guru.Spring6WebApp.domain.Book;

public interface IBookService {
    Iterable<Book> findAll();
}
