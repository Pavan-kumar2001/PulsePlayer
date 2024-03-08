package com.pulseplayer.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pulseplayer.app.entities.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>{
	

	 public Users findByEmail(String email);
	 public Users findByUsername(String username);
    

}
