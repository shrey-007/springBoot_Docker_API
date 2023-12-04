package com.example.api.controller;

import com.example.api.entity.Book;
import com.example.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//we have to create restController not controller
public class BookController {
//    @Autowired
//    private BookService bookService;
//
////    @RequestMapping(value = "/books",method = RequestMethod.GET) ye poora likhne ki jagah ek line ka code likh do
//    @GetMapping("/books")
//    public List<Book> getBooks(){
//        return this.bookService.getAllBooks();
//    }
//
//
//    //id aaegi url mai and PathVaariable us url mai aayi id ko int id mai daal dega
//
//    @GetMapping("/books/{id}")
//    public Book getBook(@PathVariable("id") int id){
//        return bookService.getBookById(id);
//    }
//
//    //Book ka  data aa rha hoga json format mai, and RequestBody us json format ke data ko
//    //Book ke object mai convert kr dega
//    @PostMapping("/books")
//    public Book addBook(@RequestBody  Book book){
//        Book book1=this.bookService.addBook(book);
//        return book1;
//    }
//
//    @DeleteMapping("/books/{id}")
//    public Book deleteBook(@PathVariable("id") int id){
//        Book book=bookService.deleteBook(id);
//        return book;
//    }
//
//    @PutMapping("/books/{id}")
//    public Book updateBook(@RequestBody Book book,@PathVariable("id") int id){
//        Book book1=this.bookService.updateBook(book,id);
//        return book1;
//    }








}
