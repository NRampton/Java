package com.codingdojo.nrampton.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.lookify.models.Song;
import com.codingdojo.nrampton.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	private SongRepository _sr;
	
	public SongService(SongRepository songRepository) {
		this._sr = songRepository;
	}

	public List<Song> getAllSongs() {
		return (List<Song>) _sr.findAll();
	}
	
	public void addSong(Song song) {
		_sr.save(song);
	}
	
	public Song getSongById(Long id) {
		return _sr.findOne(id);
	}
	
	public void destroySong(Long id) {
		_sr.delete(id);
	}
	
	public void destroyAll() {
		_sr.deleteAll();
	}
	
	public List<Song> getTopTen() {
		List<Song> topTenList = _sr.OrderByRatingDesc();
		topTenList.subList(10, topTenList.size()).clear();
		return topTenList;
	}
	
	public List<Song> searchByArtist(String search) {
		return _sr.findByArtistContaining(search);
	}
}
