package com.pulseplayer.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pulseplayer.app.entities.Song;
import com.pulseplayer.app.entities.Users;
import com.pulseplayer.app.services.SongsServices;
import com.pulseplayer.app.services.UserServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	@Autowired
	UserServices service;
	@Autowired
	SongsServices songservice;

//	@PostMapping("/login")
//	public String login(@RequestParam String email,@RequestParam String password,HttpSession session) {
//		boolean status=service.validateUser( email, password);
//
//		if(status==true) {
//			session.setAttribute("email",email);
//			String role=service.getRole(email);
//			if(role.equals("admin")) {
//				return "adminhome";
//			}else if(role.equals("customer")) {
//				return "customerhome";
//			}
//
//		}
//		return "loginfail";
//
//
//	}

	
	@GetMapping("/loginrole")
	public String logino(Principal principal) {
 
		 String user=principal.getName();

	     if(user.equals("admin")) {
	    	 return "adminhome";
	     }else {
	    	 return "customerhome";
	     }

	}
	
	
	@PostMapping("/register")
	public void addUser(@ModelAttribute Users user,HttpSession session) throws Exception{
		
		boolean userstatus=service.emailExists(user.getEmail());
		if(userstatus==false) {
			service.addUser(user);
			session.setAttribute("msg", "registrationsuccess");
		}else {
			session.setAttribute("msg", "Something Wrong Occured");
		}
	}

	@GetMapping("exploresongs")
	public String getMethodName(Principal principal,Model model) {
		String name=principal.getName();

		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");

		
		Users user=service.getUserByName(name);
		System.out.println(user);
		
		List<Song> songlist=songservice.fetchAllSongs();
		model.addAttribute("songlist", songlist);

		boolean userStatus=user.isPremium();
		System.out.println(userStatus);
		if(userStatus) {
			return "displaysongs";
		}else {
			return "samplepayment";
		}
	}
}
