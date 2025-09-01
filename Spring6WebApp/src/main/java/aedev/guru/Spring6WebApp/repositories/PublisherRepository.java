package aedev.guru.Spring6WebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import aedev.guru.Spring6WebApp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{
    
}
