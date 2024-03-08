package com.pulseplayer.app.services;

import com.pulseplayer.app.entities.Users;

public interface UserServices {

	public String addUser(Users user);

	public boolean emailExists(String email);
	public boolean validateUser(String email,String password);
	public String getRole(String email);

	public Users getUser(String email);

	public void updateUser(Users user);
	
	public void removeSessionMsg();

	public Users getUserByName(String name);

}
