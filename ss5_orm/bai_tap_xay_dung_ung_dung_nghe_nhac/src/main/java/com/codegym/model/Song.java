package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Song implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String artist;
    private String type;
    private String songPath;

    public Song() {
    }

    public Song(String name, String artist, String type, String songPath) {
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.songPath = songPath;
    }

    public Song(int id, String name, String artist, String type, String songPath) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.songPath = songPath;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    @Override
    public Song clone() {
        Song song = new Song();
        song.setName(name);
        song.setArtist(artist);
        song.setType(type);
        song.setSongPath(songPath);
        return song;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", type='" + type + '\'' +
                ", songPath='" + songPath + '\'' +
                '}';
    }
}
