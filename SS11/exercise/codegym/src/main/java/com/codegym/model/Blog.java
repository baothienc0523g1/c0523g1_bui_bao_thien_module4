package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String author;
    @NotBlank
    private String name;
    @NotBlank
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @NotBlank
    private String summary;

    @ManyToOne
    @JoinColumn(columnDefinition = "category_id", referencedColumnName = "id")
    private Category category;

}
