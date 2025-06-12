package com.negrete.music.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "albums")
public class Album {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private byte totalSongs;
    private LocalDate dateCreated;

    @ManyToOne
    private Artist artist;

    public Album() { }

    public Album(String name, byte totalSongs, Artist artist) {
        this.name = name;
        this.totalSongs = totalSongs;
        this.dateCreated = LocalDate.now();
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Name='" + name + '\'' +
                ", totalSongs=" + totalSongs +
                ", dateCreated=" + dateCreated +
                ", artist=" + artist;
    }
}
