package aedev.guru.MVC.services;

import java.util.UUID;

import aedev.guru.MVC.model.Beer;

public interface BeerService {
    Beer getBeerById(UUID id);
}
