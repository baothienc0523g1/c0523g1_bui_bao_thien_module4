package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "rents")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer code;

    @OneToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book book;

    public Rent() {
    }

    public Rent(Integer code, Book book) {
        this.code = code;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
