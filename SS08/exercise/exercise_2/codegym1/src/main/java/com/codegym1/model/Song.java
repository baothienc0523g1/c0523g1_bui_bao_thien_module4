package com.codegym1.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "LONGTEXT")
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String artist;
    @Column(columnDefinition = "LONGTEXT")
    private String musicGenre;

    public Song() {
    }

    public Song(int id, String name, String artist, String musicGenre) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.musicGenre = musicGenre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }
}
