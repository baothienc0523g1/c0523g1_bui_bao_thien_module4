package com.codegym.dto;


import com.codegym.model.Category;

import javax.validation.constraints.NotBlank;

public class BlogDto {
    @NotBlank
    private String author;
    @NotBlank
    private String name;
    @NotBlank
    private String content;
    @NotBlank
    private String summary;
    @NotBlank
    private String dayCreate;
    private Category category;

    public BlogDto() {
    }

    public BlogDto(String author, String name, String content, String summary, String dayCreate) {
        this.author = author;
        this.name = name;
        this.content = content;
        this.summary = summary;
        this.dayCreate = dayCreate;
    }

    public BlogDto(String author, String name, String content, String summary, String dayCreate, Category category) {
        this.author = author;
        this.name = name;
        this.content = content;
        this.summary = summary;
        this.dayCreate = dayCreate;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

}
