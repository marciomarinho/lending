package au.com.riosoftware.controllers;

import au.com.riosoftware.domain.Book;
import au.com.riosoftware.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    //TODO: You always have to specify which route under you're going to.
    @RequestMapping(value="", method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "books/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addBooks(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createBook(@ModelAttribute Book book){
        bookService.newBook(book);
        return "redirect:/books";
    }

    //TODO: You missed a slash before {id}
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable long id) {
         bookService.delete(id);
        return "redirect:/books";
    }
}
