package com.pergamum.library.repository;

import com.pergamum.library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepository {

    private List<Book> booksList = new ArrayList<Book>();

    public List<Book> getAllBooks(){
        return booksList.stream()
                .sorted(Comparator.comparing(Book::getAuthor).thenComparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    public Book searchBookByTitle(String title){
        Book aux = null;

        for (Book b : booksList ){
            if (b.getTitle().equals(title)){
                aux = b;
                break;
            }
        }

        return aux;
    }

    public Book save(Book book){
        Book bookAux = new Book();
        bookAux.setId(book.getIndex());
        bookAux.setTitle(book.getTitle());
        bookAux.setAuthor(book.getAuthor());
        booksList.add(bookAux);
        return bookAux;
    }

    public String delete(Integer id) {
        booksList.removeIf(x -> x.getId() == (id));
        return null;
    }

    public Book update(int id, String newAuthor){
        Book book = null;

        for (Book b : booksList){
            if (b.getId() == id)
            {   b.setAuthor(newAuthor);
                book = b;
            }
        }

        return book;
    }

}


