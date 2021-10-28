package com.codegym.model;

public class Song {
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
}
