package aedev.guru.Spring6WebApp.services;

import org.springframework.stereotype.Service;

import aedev.guru.Spring6WebApp.domain.Author;
import aedev.guru.Spring6WebApp.repositories.AuthorRepository;

@Service
public class AuthorService implements IAuthorService{

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
    
}
