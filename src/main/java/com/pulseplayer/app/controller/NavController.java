package com.pulseplayer.app.controller;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class NavController {

	@GetMapping("/loginPage")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/registerPage")
	public String registerPage() {
		return "register";
	}
	
	@GetMapping("/map-song")
	public String addSongPage() {
		return "addsongs";
	}

	@GetMapping("/samplepayment")
	public String samplepayment() {
		return "samplepayment";
	}

	    @PostMapping("/update")
	public String update(){
		return "update";
	}
	
	

}
