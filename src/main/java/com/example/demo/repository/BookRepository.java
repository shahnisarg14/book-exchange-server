package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository<Book, Integer> {
    @Query("SELECT book from Book book WHERE book.isbn=:isbn")
    public Iterable<Book> findBookByIsbn(@Param("isbn") int u);
}
