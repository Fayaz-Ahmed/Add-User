package com.demo.projectauth.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.projectauth.controller.AdminController;
import com.demo.projectauth.entity.User;
import com.demo.projectauth.service.AdminService;

@RestController
public class AdminController {
	public AdminService adminservice;

	public AdminController(AdminService adminservice) {
		this.adminservice = adminservice;
	}

	@PostMapping(path = "/admin/register")
	public User createUser(@RequestBody User user) {
		return adminservice.createUser(user);
	}

 

}
