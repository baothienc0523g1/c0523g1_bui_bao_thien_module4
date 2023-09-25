package com.codegym1.service;

import com.codegym1.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findALl();
    void add(Song song);
}
