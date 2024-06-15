package com.example.api.controller;

import com.example.api.entity.Book;
import com.example.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//we have to create restController not controller
public class BookController2 {
    @Autowired
    private BookService bookService;

    //    @RequestMapping(value = "/books",method = RequestMethod.GET) ye poora likhne ki jagah ek line ka code likh do
    //ResponseEntity is used for sending status
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> list=this.bookService.getAllBooks();
        if(list.size()<=0){
            return  ResponseEntity.ok().body(null);
        }
        else{
            return ResponseEntity.of(Optional.of(list));
        }
    }


    //id aaegi url mai and PathVaariable us url mai aayi id ko int id mai daal dega

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
        Book book= bookService.getBookById(id);
        if(book==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.of(Optional.of(book));
        }
    }

    //Book ka  data aa rha hoga json format mai, and RequestBody us json format ke data ko
    //Book ke object mai convert kr dega
    //Post mai exception aa skti hai toh ho skta hai book add hi na hui ho toh try catch ke unser rakho
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody  Book book){
        Book book1=null;
       try {
            book1=this.bookService.addBook(book);
           return ResponseEntity.status(HttpStatus.CREATED).build();
       }
       catch (Exception e){
           System.out.println(e);
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
        try{
            this.bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id") int id){
        try{
            Book book1=this.bookService.updateBook(book,id);
            return ResponseEntity.ok().body(book);
        }
        catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }








}
