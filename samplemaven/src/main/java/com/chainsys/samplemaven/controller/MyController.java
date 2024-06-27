package com.chainsys.samplemaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.samplemaven.dao.ServerManager;
import com.chainsys.samplemaven.model.UserDetails;

@Controller
public class MyController {

	
	@Autowired 
	ServerManager manager;
	
	@RequestMapping("/home")
	public String registration() {
		return "Register.jsp";
	}
	
	@PostMapping("/register")
	public String userRegistration(@RequestParam("name") String name, @RequestParam("mailid") String mailid,@RequestParam("password") String password) {
		UserDetails details = new UserDetails();
		details.setUserName(name);
		details.setMail(mailid);
		details.setPassword(password);
		manager.setUserDetails(details);
		return "Success.jsp";
	}
	
	@GetMapping("/ListUsers")
	public String listUsers(Model model) {
		System.out.println("In List User");
		List<UserDetails> listUser = manager.readUsers();
		model.addAttribute("userDetails" , listUser);
		return "ListUsers.jsp";
	}
	
	@GetMapping("/UpdateUser")
	public String updateUser(@RequestParam("nameToUpdate") String nameToUpdate, @RequestParam("passwordToUpdate") String passwordToUpdate,@RequestParam("mailid") String mailToUpdate,Model model) {
		System.out.println("In Update User");
		UserDetails details = new UserDetails();
		details.setUserName(nameToUpdate);
		details.setPassword(passwordToUpdate);
		details.setMail(mailToUpdate);
		manager.updateUser(details);
		List<UserDetails> listUser = manager.readUsers();
		model.addAttribute("userDetails" , listUser);
		return "ListUsers.jsp";
	}
	
	@PostMapping("/DeleteUser")
	public String deleteUser(@RequestParam("mailid") String mailToDelete,Model model) {
		System.out.println("In Delete User");
		UserDetails details = new UserDetails();
		details.setMail(mailToDelete);
		manager.deleteUser(details);
		List<UserDetails> listUser = manager.readUsers();
		model.addAttribute("userDetails" , listUser);
		return "ListUsers.jsp";
	}
}
