package com.pulseplayer.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pulseplayer.app.entities.PlayList;

public interface PlayListRepository extends JpaRepository<PlayList, Integer>{

}
