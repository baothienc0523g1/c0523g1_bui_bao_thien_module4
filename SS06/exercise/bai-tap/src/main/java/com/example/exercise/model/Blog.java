package com.example.exercise.model;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String name;
    private String summary;
    @Column(columnDefinition = "LONGTEXT")
    private String content;

    public Blog(String author, String content, String summary, String name) {
        this.author = author;
        this.content = content;
        this.summary = summary;
        this.name = name;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
