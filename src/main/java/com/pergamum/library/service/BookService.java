package com.pergamum.library.service;

import com.pergamum.library.model.Book;
import com.pergamum.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }

    public Book searchBookByTitle(String title){
        return bookRepository.searchBookByTitle(title);
    }

    public String deleteBook(int id){
        bookRepository.delete(id);
        return "Book deleted!";
    }

    public Book updateBook(int id, String newAuthor){
        return bookRepository.update(id, newAuthor);
    }






}
