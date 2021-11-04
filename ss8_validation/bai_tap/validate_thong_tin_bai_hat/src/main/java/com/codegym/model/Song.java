package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Song {//implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(max = 800)
    @Pattern(regexp = "^[A-z0-9]$", message = "Không được phép để trống,Không vượt quá 800 ký tự!Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String songName;
    @NotEmpty
    @Size(max = 300)
    @Pattern(regexp = "^[A-z0-9]$", message = "Không được phép để trống,Không quá 300 ký tự,Không chứa các kí tự đặc biệt như @ ; , . = - + , ….!")
    private String artist;
    @NotEmpty
    @Size(max = 1000)
    @Pattern(regexp = "^[A-z0-9,]$", message = "Không được phép để trống,Không vượt quá 1000 ký tự !")
    private String type;

    public Song() {
    }

    public Song(Long id, String songName, String artist, String type) {
        this.id = id;
        this.songName = songName;
        this.artist = artist;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
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

    public void setType(String typeOfMusic) {
        this.type = typeOfMusic;
    }

   // @Override
    //    public boolean supports(Class<?> clazz) {
    //        return Song.class.isAssignableFrom(clazz);
    //    }
    //
    //    @Override
    //    public void validate(Object target, Errors errors) {
    //        Song song = (Song) target;
    //        ValidationUtils.rejectIfEmpty(errors, "songName", "songName.empty");
    //        String songName=song.getSongName();
    //        String artist =song.getArtist();
    //        String type =song.getType();
    //    }



}
