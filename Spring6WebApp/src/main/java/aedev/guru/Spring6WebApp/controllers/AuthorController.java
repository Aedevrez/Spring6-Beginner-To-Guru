package aedev.guru.Spring6WebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import aedev.guru.Spring6WebApp.services.IAuthorService;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AuthorController {
    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }
    
}
