package com.negrete.music.repository;

import com.negrete.music.model.Album;
import com.negrete.music.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    List<Album> findByArtist(Artist artist);
    boolean existsByNameAndArtist(String name, Artist artist);
}
