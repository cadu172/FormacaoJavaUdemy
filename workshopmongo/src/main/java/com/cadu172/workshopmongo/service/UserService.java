package com.cadu172.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadu172.workshopmongo.domain.User;
import com.cadu172.workshopmongo.repository.UserRepository;
import com.cadu172.workshopmongo.service.exception.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		
		List<User> listUser = userRepository.findAll();
		
		return listUser;
		
	}
	
	public User findById(String id) {
		
		Optional<User> user = userRepository.findById(id);
		
		return user.orElseThrow(() -> new ResourceNotFoundException("User ID "+id+" não encontrado"));
	
	}
	
}
