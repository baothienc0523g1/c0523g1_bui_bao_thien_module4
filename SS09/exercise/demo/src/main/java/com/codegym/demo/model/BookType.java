package com.codegym.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "type_of_book")
public class BookType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String typeName;

    @OneToMany(mappedBy = "bookType")
    private Set<Book> bookSet;

    public BookType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public BookType(int id) {
        this.id = id;
    }

    public BookType(String typeName) {
        this.typeName = typeName;
    }

    public BookType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
