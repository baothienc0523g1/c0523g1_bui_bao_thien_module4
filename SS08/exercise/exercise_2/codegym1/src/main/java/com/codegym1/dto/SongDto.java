package com.codegym1.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class SongDto implements Validator {
    @NotBlank(message = "Please fill this field")
    private String name;
    @NotBlank(message = "Please fill this field")
    private String artist;
    @NotBlank(message = "Please fill this field")
    private String musicGenre;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;

        String letter = "[A-Za-z ]+$";
        String genreRegex = "[A-Za-z]+(,? ?[A-Za-z]+)*";

        String name = songDto.getName();
        String artist = songDto.getArtist();
        String genre = songDto.getMusicGenre();

        if (!name.matches(letter)) {
            errors.rejectValue("name", null, "Song name can't have special symbols");
        }
        if (!artist.matches(letter)) {
            errors.rejectValue("artist", null, "Artist name can't have special symbols");
        }
        if (name.length() > 800 || name.length() < 1) {
            errors.rejectValue("name", null, "Song name must be greater than 1 letter and " +
                    "less than 800 letters");
        }
        if (artist.length() > 300 || artist.length() < 1) {
            errors.rejectValue("artist", null, "Artist name must be greater than 1 letter and " +
                    "less than 300 letters");
        }
        if (genre.length() > 1000 || genre.length() < 1) {
            errors.rejectValue("musicGenre", null, "Music genre must be greater than 1 letter and " +
                    "less than 1000 letters");
        }
        if (!genre.matches(genreRegex)) {
            errors.rejectValue("musicGenre", null, "Wrong syntax of music genre. Only letters and ',' " +
                    "is accepted!");
        }

    }

    public SongDto() {
    }

    public SongDto(String name, String artist, String musicGenre) {
        this.name = name;
        this.artist = artist;
        this.musicGenre = musicGenre;
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
