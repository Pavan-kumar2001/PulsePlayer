package com.pulseplayer.app.services;

import java.util.List;

import com.pulseplayer.app.entities.Song;

public interface SongsServices {
	public void addSong(Song song);
    public boolean songExists(String name);
    public List<Song> fetchAllSongs();
	public void update(Song song);

}