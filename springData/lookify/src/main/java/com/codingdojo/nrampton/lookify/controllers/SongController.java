package com.codingdojo.nrampton.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.nrampton.lookify.models.Song;
import com.codingdojo.nrampton.lookify.services.SongService;

@Controller
public class SongController {
	
	private final SongService _ss;
	public SongController(SongService songService) {
		this._ss = songService;
	}
	
	@RequestMapping("/")
	public String landing() {
		return "landing";
	}
	
	@RequestMapping("/dashboard")
	public String showDashboard(Model model) {
		List<Song> songs = _ss.getAllSongs();
		model.addAttribute("songs", songs);
		return "dashboard";
	}
	
	@RequestMapping("/songs/new")
	public String enterNewSong(Model model, @ModelAttribute("song") Song song) {
		return "addSong";
	}
	
	@PostMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addSong";
		} else {
			_ss.addSong(song);
			return "redirect:/dashboard";			
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", _ss.getSongById(id));
		return "oneSong";
	}
	
	@RequestMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		_ss.destroySong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/songs/theNuclearOption/AndThisTimeIMeanIt")
	public String deleteAll() {
		_ss.destroyAll();
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/search/topTen")
	public String getTopTen(Model model) {
		model.addAttribute("songs", _ss.getTopTen());
		return "topTen";
	}
	
	@PostMapping("/search")
	public String searchByArtist(Model model, @RequestParam("search") String term) {
		model.addAttribute("term", term);
		model.addAttribute("results", _ss.searchByArtist(term));
		return "searchResults";
	}
}
