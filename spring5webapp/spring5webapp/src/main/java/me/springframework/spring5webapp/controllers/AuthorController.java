package me.springframework.spring5webapp.controllers;

import me.springframework.spring5webapp.repositories.AuthorRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController
{

    private final AuthorRepo authorRepoObj;

    public AuthorController(AuthorRepo authorRepoObj) {
        this.authorRepoObj = authorRepoObj;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model authorsModel)
    {
        authorsModel.addAttribute("authors", authorRepoObj.findAll());

        return "/authors/list";
    }
}
