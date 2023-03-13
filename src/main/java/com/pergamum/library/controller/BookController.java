package com.pergamum.library.controller;


import com.pergamum.library.model.Book;
import com.pergamum.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("add")
    public Book addBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @GetMapping("books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/searchBy/{title}")
    public Book searchBookByTitle(@PathVariable String title){
        return bookService.searchBookByTitle(title);
    }

    @PutMapping("update/{id}/{newAuthor}")
    public Book updateBook(@PathVariable int id, @PathVariable String newAuthor){
        return bookService.updateBook(id, newAuthor);
    }

    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable int id){
        return bookService.deleteBook(id);
    }

}
