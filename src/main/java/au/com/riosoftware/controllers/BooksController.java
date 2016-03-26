package au.com.riosoftware.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/books")
public class BooksController {

    @RequestMapping(method = RequestMethod.GET)
    public String listBooks() {
        return "books/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addBooks() {
        return "books/new";
    }

}
