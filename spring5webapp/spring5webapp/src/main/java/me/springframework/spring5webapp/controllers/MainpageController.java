package me.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainpageController
{

    @RequestMapping("/")
    public String getPaths()
    {
        return "/mainpage/links";
    }

}
