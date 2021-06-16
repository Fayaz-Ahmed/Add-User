package com.demo.projectauth.service;

import com.demo.projectauth.controller.MailController;
import com.demo.projectauth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.demo.projectauth.Repository.UserRepository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Random;

@Service
public class UserService {
	public UserRepository userRepository;
public MailController mailController;
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User getById(Long id) {
		return userRepository.findById(id).orElseThrow();
	}

	public User create(User user) {
	return 	userRepository.save(user);
	}

}
