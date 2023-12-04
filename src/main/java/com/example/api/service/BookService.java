package com.example.api.service;

import com.example.api.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api.dao.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
       List<Book> list=(List<Book>) this.bookRepository.findAll();
       return list;
    }

    public Book getBookById(int id){
        return this.bookRepository.findById(id);
    }

    public Book addBook(Book book){
       Book book1=this.bookRepository.save(book);
        return book1;
    }

    public Book deleteBook(int id){
        Book book=bookRepository.deleteById(id);
        return book;
    }

    public Book updateBook(Book book,int id){
        Book book1=bookRepository.save(book);
        return book1;
    }



}
