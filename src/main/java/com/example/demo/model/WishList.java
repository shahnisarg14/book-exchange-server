package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wId;
    private Date date;

    public WishList() {

    }

    @ManyToMany
    @JoinTable(
            name = "wishlist_book",
            joinColumns = { @JoinColumn(name = "wId") },
            inverseJoinColumns = { @JoinColumn(name = "isbn") }
    )
    Set<Book> books = new HashSet<>();

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public int getwId() {
        return wId;
    }

    public void setwId(int wId) {
        this.wId = wId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
