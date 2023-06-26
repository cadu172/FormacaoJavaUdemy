package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {

	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		
		return userRepository.findAll();
		
	}
	
	public User findById(Long id) {
		
		Optional<User> user = userRepository.findById(id);
		
		return user.get();
		
	}
	
}
