package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String firstName;
    private String lastName;
    private String emailId;
    private String cellNumber;
    private boolean isAdmin = false;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wId", referencedColumnName = "wId")
    private WishList wishList;

    public User(String username, String password, String firstName,
                String lastName, String emailId, boolean isAdmin, WishList wishList) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.isAdmin = isAdmin;
        this.wishList = wishList;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }
}
