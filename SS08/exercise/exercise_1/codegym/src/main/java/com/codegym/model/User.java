package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(255) not null")
    private String firstName;
    @Column(columnDefinition = "varchar(255) not null")
    private String lastName;
    @Column(columnDefinition = "int not null")
    private Integer age;
    @Column(columnDefinition = "varchar(30) not null")
    private String phoneNumber;
    @Column(columnDefinition = "varchar(255) not null")
    private String email;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, Integer age, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
