package com.codegym.demo1.model;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String content;

    private String summary;

    private String dayCreate;

    @ManyToOne
    @JoinColumn(columnDefinition = "category_id", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String author, String name, String content, String summary, String dayCreate) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.content = content;
        this.summary = summary;
        this.dayCreate = dayCreate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDayCreate() {
        return dayCreate;
    }

    public void setDayCreate(String dayCreate) {
        this.dayCreate = dayCreate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", summary='" + summary + '\'' +
                ", dayCreate='" + dayCreate + '\'' +
                ", category=" + category +
                '}';
    }
}
