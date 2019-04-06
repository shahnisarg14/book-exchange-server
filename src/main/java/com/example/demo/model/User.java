package com.example.demo.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    private String username;
    private String password;
    private String fName;
    private String lName;
    private String emailId;
    private String cellNumber;
    private boolean isAdmin = false;

    public User(String username, String password, String fName, String lName, String emailId, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.emailId = emailId;
        this.isAdmin = isAdmin;
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

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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
}
