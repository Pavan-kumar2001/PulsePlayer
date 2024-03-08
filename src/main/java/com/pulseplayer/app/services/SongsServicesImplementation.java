package com.pulseplayer.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pulseplayer.app.entities.PlayList;
import com.pulseplayer.app.entities.Song;
import com.pulseplayer.app.repository.SongsRepository;

@Service
public class SongsServicesImplementation implements SongsServices {
	
	@Autowired
	SongsRepository repo;

	@Override
	public void addSong(Song song) {
		repo.save(song);		
	}

	@Override
	public boolean songExists(String name) {
		Song song=repo.findByName(name);
		if(song==null) {
			return false;
		}
		return true;
	}

	@Override
	public List<Song> fetchAllSongs() {
		List<Song> li=repo.findAll();
		return li;
	}

	@Override
	public void update(Song song) {
		// TODO Auto-generated method stub
		repo.save(song);
		
	}

	

}


