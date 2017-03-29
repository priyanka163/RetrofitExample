package com.example.next.githubsample.models;

import java.util.Date;

/**
 * Created by next on 10/3/17.
 */
public class Author {
    private String name;
    private String email;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
