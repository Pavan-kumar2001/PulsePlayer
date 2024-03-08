package com.pulseplayer.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pulseplayer.app.entities.PlayList;
import com.pulseplayer.app.repository.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService{

	@Autowired
	PlayListRepository repo;

	@Override
	public void addPlayList(PlayList playlist) {
		repo.save(playlist);
	}

	
	@Override
	public List<PlayList> findPlayList() {
		return repo.findAll();
	}
}
