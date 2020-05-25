package com.smartequate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartequate.dto.User;
import com.smartequate.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	
	public User getUserByName(String name) {
		return userRepo.findByUsername(name);
	}
}
