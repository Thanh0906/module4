package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private int id;
    private String name;
    private String artist;
    private String type;
    private MultipartFile songPath;

    public SongForm() {
    }

    public SongForm(int id, String name, String artist, String type, MultipartFile songPath) {
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

    public MultipartFile getSongPath() {
        return songPath;
    }

    public void setSongPath(MultipartFile songPath) {
        this.songPath = songPath;
    }
}
