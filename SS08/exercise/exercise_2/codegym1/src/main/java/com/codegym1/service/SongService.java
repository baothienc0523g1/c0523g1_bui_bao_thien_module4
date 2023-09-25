package com.codegym1.service;

import com.codegym1.model.Song;
import com.codegym1.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<Song> findALl() {
        return this.songRepository.findAll();
    }

    @Override
    public void add(Song song) {
        this.songRepository.save(song);
    }
}
