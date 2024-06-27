package com.chainsys.samplemaven.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.samplemaven.model.UserDetails;

public class Mapper implements RowMapper<UserDetails> {

	@Override
	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetails details = new UserDetails();
		details.setUserName(rs.getString("user_name"));
		details.setMail(rs.getString("mail_id"));
		details.setPassword(rs.getString("password"));
		return details;
	}
	
	/*
	 * public UserDetails checkLogin(ResultSet rs, int rowNum) throws SQLException {
	 * UserDetails details = new UserDetails();
	 * details.setMail(rs.getString("mail_id"));
	 * details.setPassword(rs.getString("password")); return details; }
	 */

}
