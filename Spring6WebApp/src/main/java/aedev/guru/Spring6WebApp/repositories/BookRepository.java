package aedev.guru.Spring6WebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import aedev.guru.Spring6WebApp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
    
}
