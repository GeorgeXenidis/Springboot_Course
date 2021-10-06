package me.springframework.spring5webapp.controllers;

import me.springframework.spring5webapp.repositories.PublisherRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController
{

    private PublisherRepo publisherRepoObj;

    public PublisherController(PublisherRepo publisherRepoObj) {
        this.publisherRepoObj = publisherRepoObj;
    }

    @RequestMapping("/publishers")
    public String getPublishers(Model publishersModel)
    {
        //Creates an M.V.C. model for publishers with the name "publishers" and with content everything found inside publisherRepoObj.
        publishersModel.addAttribute("publishers", publisherRepoObj.findAll());

        return "/publishers/list";
    }

}
