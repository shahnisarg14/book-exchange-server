package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_isbn", referencedColumnName = "isbn")
    private Book book;

    public Posting(){

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getpId() {
        return pId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
