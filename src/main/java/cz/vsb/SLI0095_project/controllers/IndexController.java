package cz.vsb.SLI0095_project.controllers;

import cz.vsb.SLI0095_project.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    AuthorService authorService;

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
}
