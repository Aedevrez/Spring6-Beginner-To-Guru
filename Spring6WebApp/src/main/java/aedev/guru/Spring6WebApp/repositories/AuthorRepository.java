package aedev.guru.Spring6WebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import aedev.guru.Spring6WebApp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
    
}
