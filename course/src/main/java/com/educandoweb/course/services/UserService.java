package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		
		return userRepository.findAll();
		
	}
	
	public User findById(Long id) {
		
		Optional<User> obj = userRepository.findById(id);
		
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		//return obj.orElseThrow(() -> new CarlosException("Recurso Não Localizado"));
		
	}
	
	public User insert(User user) {
		
		return userRepository.save(user);
		
	}
	
	public void delete(Long id) {
		
		userRepository.deleteById(id);
		
	}
	
	public User update(Long id, User user) {
		
		User aux = userRepository.getReferenceById(id);	
		
		aux.setEmail(user.getEmail());
		aux.setName(user.getName());
		aux.setPhone(user.getPhone());
		
		return userRepository.save(aux);
	
		
	}
	
	
}
