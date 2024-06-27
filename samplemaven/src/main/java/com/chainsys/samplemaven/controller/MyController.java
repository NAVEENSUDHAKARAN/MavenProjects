package com.chainsys.samplemaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.samplemaven.dao.UserDetailsImpl;
import com.chainsys.samplemaven.model.UserDetails;

@Controller
public class MyController {

	
	@Autowired 
	UserDetailsImpl userDetailsImpl;
	
	String LIST_USER_JSP = "ListUsers.jsp";
	String userDetails =  "userDetails";
	
	@RequestMapping("/Home")
	public String registration() {
		return "LoginPage.jsp";
	}
	
	@PostMapping("/CheckLogin")
	public String checkLogin(@RequestParam("email") String mail, @RequestParam("loginPassword") String loginPassword){
		UserDetails details = new UserDetails();
		details.setMail(mail);
		details.setPassword(loginPassword);
		List<UserDetails> checked = userDetailsImpl.checkLogin(mail, loginPassword);
		System.out.println("----->" + checked);
		if(!checked.isEmpty()) {
			return "Success.jsp";
		}else {
			return "Register.jsp";
		}
	}
	
	@PostMapping("/Register")
	public String userRegistration(@RequestParam("name") String name, @RequestParam("mailid") String mailid,@RequestParam("password") String password) {
		UserDetails details = new UserDetails();
		details.setUserName(name);
		details.setMail(mailid);
		details.setPassword(password);
		userDetailsImpl.setUserDetails(details);
		return "Success.jsp";
	}
	
	@GetMapping("/ListUsers")
	public String listUsers(Model model) {
		List<UserDetails> listUser = userDetailsImpl.readUsers();
		model.addAttribute(userDetails , listUser);
		return LIST_USER_JSP;
	}
	
	@GetMapping("/UpdateUser")
	public String updateUser(@RequestParam("nameToUpdate") String nameToUpdate, @RequestParam("passwordToUpdate") String passwordToUpdate,@RequestParam("mailid") String mailToUpdate,Model model) {
		UserDetails details = new UserDetails();
		details.setUserName(nameToUpdate);
		details.setPassword(passwordToUpdate);
		details.setMail(mailToUpdate);
		userDetailsImpl.updateUser(details);
		List<UserDetails> listUser = userDetailsImpl.readUsers();
		model.addAttribute("userDetails" , listUser);
		return LIST_USER_JSP;
	}
	
	@PostMapping("/DeleteUser")
	public String deleteUser(@RequestParam("mailid") String mailToDelete,Model model) {
		UserDetails details = new UserDetails();
		details.setMail(mailToDelete);
		userDetailsImpl.deleteUser(details);
		List<UserDetails> listUser = userDetailsImpl.readUsers();
		model.addAttribute("userDetails" , listUser);
		return LIST_USER_JSP;
	}
	
	@PostMapping("/SearchUser")
	public String searchUser(@RequestParam("searchUser") String name, Model model) {
		List<UserDetails> searchUser = userDetailsImpl.searchUser(name);
		model.addAttribute("userDetails" , searchUser);
		return LIST_USER_JSP;
	}
}
