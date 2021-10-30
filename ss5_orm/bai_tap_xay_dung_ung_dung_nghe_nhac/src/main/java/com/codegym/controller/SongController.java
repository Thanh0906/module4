package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.model.SongForm;
import com.codegym.service.HibernateSongServiceImpl;
import com.codegym.service.ISongService;
import com.codegym.service.SongServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Controller
@RequestMapping("/song")
public class SongController {
    @Value("${upload}")
    private String songUpload;

    private ISongService iSongService = new SongServiceImpl();

    @GetMapping("")
    public String index(Model model) {
        List<Song> songList = iSongService.findAll();
        model.addAttribute("songList", songList);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("songForm", new SongForm());
            modelAndView.addObject("type",
                    new String[] {"Nhạc trẻ", "Nhạc thiếu nhi","Nhạc Trữ tình", "Nhạc quốc tế", "Nhạc Bolero", "Nhạc Vàng", "Rap-Hiphop"});
            return modelAndView;
    }

    @PostMapping("/save")
    public String saveSong(@ModelAttribute SongForm songForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = songForm.getSongPath();
        String songFileName = multipartFile.getOriginalFilename();
        String[] array = songFileName.split("\\.");
        if (array[1].equals("mp3") || array[1].equals("wav") || array[1].equals("ogg") || array[1].equals("m4p")) {
            try {
                FileCopyUtils.copy(songForm.getSongPath().getBytes(), new File(songUpload + songFileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Song song = new Song(songForm.getName(), songForm.getArtist(), songForm.getType(), songFileName);
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        } else {
            redirectAttributes.addFlashAttribute("message", "Thêm mới thất bại");
        }
        return "redirect:/song";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id ) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("music", iSongService.findById(id));
        return modelAndView;

    }
    @PostMapping ("/delete")
    public String delete (Song song, RedirectAttributes redirectAttributes) {
        iSongService.delete(song.getId());
        redirectAttributes.addFlashAttribute("message", "Delete successful");
        return "redirect:/music";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id ) {

        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("song", iSongService.findById(id));
        modelAndView.addObject("type",
                new String[] {"Nhạc trẻ", "Nhạc thiếu nhi","Nhạc Trữ tình", "Nhạc quốc tế", "Nhạc Bolero", "Nhạc Vàng", "Rap-Hiphop"});
        return modelAndView;

    }
    @PostMapping("/update")
    public String updateSong(SongForm songForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = songForm.getSongPath();
        String fileName = multipartFile.getOriginalFilename();
        String[] array = fileName.split("\\.");
        if (array[1].equals("mp3") || array[1].equals("wav") || array[1].equals("ogg") || array[1].equals("m4p")) {
            try {
                FileCopyUtils.copy(songForm.getSongPath().getBytes(), new File(songUpload + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
           Song song = new Song(songForm.getId(),songForm.getName(), songForm.getArtist(),
                  songForm.getType(), fileName);
            iSongService.update(song);
            redirectAttributes.addFlashAttribute("message", "update thành công");
        } else {
            redirectAttributes.addFlashAttribute("message", "Update thất bại");
        }
        return "redirect:/music";
    }
}
