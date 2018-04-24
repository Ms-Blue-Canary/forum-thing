package com.example.forumthing.models;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Thread {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String body;

    public Thread() {
    }

    public int getId() {
        return id;
    }

    public String getbody() {
        return body;
    }

    public void setName(String name) {
        this.body = body;
    }

}
