package com.chainsys.samplemaven.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsDAO {

	
	public List getUserDetails();
}
