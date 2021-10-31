package com.codegym.service;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SongServiceImpl implements ISongService{
    @Override
    public List<Song> findAll() {
        return null;
    }

    @Override
    public void save(Song song) {

    }

    @Override
    public Song findById(int id) {
        return null;
    }

    @Override
    public Song update(Song song) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
    //@Autowired
    //    private ISongRepository songRepository;
    //
    //    @Override
    //    public List<Song> findAll() {
    //        return songRepository.findAll();
    //    }
    //
    //    @Override
    //    public void save(Song song) {
    //        songRepository.save(song);
    //    }
    //
    //    @Override
    //    public Song findById(int id) {
    //        return songRepository.findById(id);
    //    }
    //
    //    @Override
    //    public Song update(Song song) {
    //        return songRepository.update(song);
    //    }
    //
    //    @Override
    //    public void delete(int id) {
    //        songRepository.delete(id);
    //    }
}
