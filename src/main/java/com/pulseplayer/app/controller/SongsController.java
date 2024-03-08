package com.pulseplayer.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pulseplayer.app.entities.PlayList;
import com.pulseplayer.app.entities.Song;
import com.pulseplayer.app.services.SongsServices;


@Controller
public class SongsController {
	@Autowired
	SongsServices service;

	@PostMapping("/addSongs")
	public String addSong(@ModelAttribute Song song) {
		boolean status=service.songExists(song.getName());

		if(status==false)
			service.addSong(song);
		else
			return	"songfail";

		return "songsuccessfull";

	}


	@GetMapping("/map-viewsong")
	public String getAllSongs(Model model) {
		boolean primestatus=true;

		if(primestatus==true) {
			List<Song> songlist=service.fetchAllSongs();
			model.addAttribute("songlist",songlist);
			return "displaysongs";
		}
		else
			return "makepayment";
	}

	
	
	
}


