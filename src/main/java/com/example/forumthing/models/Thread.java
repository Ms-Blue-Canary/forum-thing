package com.example.forumthing.models;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import com.example.forumthing.models.Thread;
import com.example.forumthing.models.data.ThreadDao;
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
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "You did not write anything")
    private String body;

    public Thread() { }

    public Thread(String body) {
        this.body = body;
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.body;
    }

    public void setDescription(String description) {
        this.body = body;
    }

}

