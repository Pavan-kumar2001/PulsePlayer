package com.pulseplayer.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pulseplayer.app.entities.Users;
import com.pulseplayer.app.repository.UsersRepository;
import com.pulseplayer.app.security.CustomUser;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Service
public class UserServicesImplementation implements UserServices,UserDetailsService {
	
	@Autowired
	UsersRepository repo;


	@Override
	public String addUser(Users user) {
	
		 BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		String password=passwordEncoder.encode(user.getPassword());
		String role=user.getRole();
		if(role==null) {
			user.setRole("Customer");
		}
		user.setPassword(password);
	repo.save(user);
	return "User created and saved";
		
	}

	@Override
	public boolean emailExists(String email) 
	{
		if(repo.findByEmail(email)==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		  Users user=repo.findByEmail(email);
		   if(user.getPassword().equals(password)) {
			   return true;
		   }
		return false;
	}

	@Override
	public String getRole(String email) {
		Users user= repo.findByEmail(email);
		return user.getRole();
	}

	@Override
	public Users getUser(String email) {
		
		Users user=repo.findByEmail(email);
		return user;
	}

	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		repo.save(user);
		
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Users user=repo.findByEmail(email);
		System.out.println(user);
		
		if(user==null) {
			throw new UsernameNotFoundException("not found");
		}
		return new CustomUser(user);
	}

	@Override
	public void removeSessionMsg() {
		// TODO Auto-generated method stub
		
		HttpSession session =((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		session.removeAttribute("msg");
		
}

	public Users getUserByName(String name) {
		// TODO Auto-generated method stub
		Users user=repo.findByUsername(name);
		return user;
	}

	


}
