package com.pulseplayer.app.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.pulseplayer.app.entities.PlayList;
import com.pulseplayer.app.entities.Song;
import com.pulseplayer.app.services.PlayListService;
import com.pulseplayer.app.services.SongsServices;


@Controller
public class PlayListController {

	@Autowired
	PlayListService pserv;

	@Autowired
	SongsServices sserv;

	@GetMapping("/map-playlist")
	public String createPlayList(Model model) {
		List<Song> songlist=sserv.fetchAllSongs();
		model.addAttribute("songlist",songlist);
		return "createplaylist";
	}

	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		//adding playlist

		pserv.addPlayList(playlist);


		//update song table

		List<Song> songsList=playlist.getSong() ;

		for(Song song : songsList) {
			song.getPlaylist().add(playlist);
			sserv.update(song);
		}

		return "playlistsuccess";
	}
	
	@GetMapping("/map-viewplaylist")
	public String viewplaylist(Model model) {
		
	 List<PlayList> plist= pserv.findPlayList();
	  model.addAttribute("plist", plist);
		return "viewplaylist";
	}
	

}
