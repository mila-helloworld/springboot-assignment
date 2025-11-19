package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    // READ: list all books
    @GetMapping("/list")
    public String listBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books-list";   // /WEB-INF/views/books-list.jsp
    }

    // SHOW CREATE FORM
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.findAll());
        return "book-form";    // /WEB-INF/views/book-form.jsp
    }

    // HANDLE FORM SUBMIT (CREATE)
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book, Model model) {
        try {
            bookService.save(book);
            return "redirect:/books/list";
        } catch (DataIntegrityViolationException ex) {
            model.addAttribute("errorMessage",
                    "Could not save book. Check that ISBN is unique and all fields are valid.");
            model.addAttribute("book", book);
            model.addAttribute("authors", authorService.findAll());
            return "book-form";
        }
    }
}

