package aedev.guru.Spring6WebApp.services;

import org.springframework.stereotype.Service;

import aedev.guru.Spring6WebApp.domain.Book;
import aedev.guru.Spring6WebApp.repositories.BookRepository;

@Service
public class BookService implements IBookService{

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
    
}
