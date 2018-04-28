package com.example.forumthing.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reply {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "You did not write anything")
    private String body;


    public Reply() { }

    public Reply(String body) {
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
