package com.cadu172.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadu172.workshopmongo.domain.User;
import com.cadu172.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		
		List<User> listUser = userRepository.findAll();
		
		return listUser;
		
	}
	
}
