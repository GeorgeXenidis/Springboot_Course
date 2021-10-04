package me.springframework.spring5webapp.controllers;

import me.springframework.spring5webapp.repositories.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController
{

    private final BookRepo bookRepoObj;

    public BookController(BookRepo bookRepoObj) {
        this.bookRepoObj = bookRepoObj;
    }

    @RequestMapping("/books")
    public String getBooks(Model booksModel)
    {
        booksModel.addAttribute("books", bookRepoObj.findAll());

        return "/books/books_list";
    }
}
