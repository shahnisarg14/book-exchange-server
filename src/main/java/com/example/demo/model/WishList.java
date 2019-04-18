package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class WishList {

    @Id
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
