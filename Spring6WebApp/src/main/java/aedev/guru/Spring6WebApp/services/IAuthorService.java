package aedev.guru.Spring6WebApp.services;

import aedev.guru.Spring6WebApp.domain.Author;

public interface IAuthorService {
    Iterable<Author> findAll();
}
