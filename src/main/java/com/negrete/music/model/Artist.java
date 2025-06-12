package com.negrete.music.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String artistName;
    private String realName;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private LocalDate lastDateSearch;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Album> albums;

    public Artist() {}

    public Artist(String artistName, String realName, Genre genre) {
        this.artistName = artistName;
        this.realName = realName;
        this.genre = genre;
        this.lastDateSearch = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDate getLastDateSearch() {
        return lastDateSearch;
    }

    public void setLastDateSearch(LocalDate lastDateSearch) {
        this.lastDateSearch = lastDateSearch;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "ArtistName='" + artistName + '\'' +
                ", realName='" + realName + '\'' +
                ", genre=" + genre +
                ", lastDateSearch=" + lastDateSearch;
    }
}
