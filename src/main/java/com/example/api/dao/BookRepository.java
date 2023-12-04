package com.example.api.dao;

import com.example.api.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
    public Book deleteById(int id);
}
