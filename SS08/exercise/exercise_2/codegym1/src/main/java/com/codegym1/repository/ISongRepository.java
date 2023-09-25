package com.codegym1.repository;

import com.codegym1.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ISongRepository extends JpaRepository<Song, Integer> {
}
