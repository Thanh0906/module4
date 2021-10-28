package com.codegym.service;

import com.codegym.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongServiceImpl implements ISongService{
    private List<Song> songList = new ArrayList<>();

    @Override
    public List<Song> findAll() {
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }
}
