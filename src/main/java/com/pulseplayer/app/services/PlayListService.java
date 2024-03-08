package com.pulseplayer.app.services;

import java.util.List;

import com.pulseplayer.app.entities.PlayList;

public interface PlayListService {
	public void addPlayList(PlayList playlist);

	public List<PlayList> findPlayList();
}
