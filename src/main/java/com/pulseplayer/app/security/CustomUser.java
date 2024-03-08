package com.pulseplayer.app.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pulseplayer.app.entities.Users;

import jakarta.servlet.http.HttpSession;

public class CustomUser implements UserDetails {

	@Autowired
	Users user;
	public CustomUser(Users user) {
		super();
		this.user = user;
		
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
SimpleGrantedAuthority authority=new SimpleGrantedAuthority(user.getRole()); 
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		// TODO Aut-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
