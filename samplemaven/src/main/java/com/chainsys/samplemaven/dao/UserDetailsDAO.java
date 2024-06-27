package com.chainsys.samplemaven.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.samplemaven.model.UserDetails;

@Repository
public interface UserDetailsDAO {

	public void setUserDetails(UserDetails details);
	
	public List<UserDetails> readUsers() ;
	
	public void updateUser(UserDetails details);

	public void deleteUser(UserDetails details);
	
	public List<UserDetails> searchUser(String name);

}
