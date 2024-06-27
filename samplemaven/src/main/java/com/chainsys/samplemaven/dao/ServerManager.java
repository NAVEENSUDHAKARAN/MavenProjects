package com.chainsys.samplemaven.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.chainsys.samplemaven.mapper.Mapper;
import com.chainsys.samplemaven.model.UserDetails;

@Configuration
public class ServerManager {
	
	@Autowired
	JdbcTemplate connect;
	
	public void setUserDetails(UserDetails details) {
		String query = "insert into user_details (user_name, mail_id, password) values (?,?,?)";
		Object[] params = {details.getUserName(), details.getMail(), details.getPassword()};
		connect.update(query, params);
		System.out.println("Inserted Successfully!!!");
	}
	
	public List<UserDetails> readUsers() {
		String query = "select user_name, mail_id, password from user_details";
		return connect.query(query,new Mapper());
	}
	
	public void updateUser(UserDetails details) {
		String query = "update user_details set user_name = ?, password = ? where mail_id = ? ";
		Object[] params = {details.getUserName(), details.getPassword(), details.getMail()};
		connect.update(query, params);
		System.out.println("Updated Successfully!!!");	
	}
	
	public void deleteUser(UserDetails details) {
		String query = "delete from user_details where mail_id=?";
		connect.update(query, details.getMail());
		System.out.println("Deleted Successfully!!!");
	}
	
}
