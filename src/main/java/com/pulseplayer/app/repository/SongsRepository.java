package com.pulseplayer.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pulseplayer.app.entities.Song;

public interface SongsRepository extends JpaRepository<Song,Integer>{

	public Song findByName(String name);

}
