package me.springframework.spring5webapp.controllers;

import me.springframework.spring5webapp.domain.Book;
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
        //Creates an M.V.C. model for books with the name "books" and with content everything found inside bookRepoObj.
        booksModel.addAttribute("books", bookRepoObj.findAll());

        return "/books/list";
    }
}
