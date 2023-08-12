package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.GenericException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		
		return userRepository.findAll();
		
	}
	
	public User findById(Long id) {
		
		Optional<User> obj = userRepository.findById(id);
		
		/* orElseThrow: dispara uma exceção caso o objeto esteja vazio
		 * */
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		
	}
	
	public User insert(User user) {
		
		return userRepository.save(user);
		
	}
	
	public void delete(Long id) {
		
		try {
			userRepository.deleteById(id);
		}
		catch ( DataIntegrityViolationException e ) {
			//throw new DatabaseException(e.getMessage());
			throw new DatabaseException("Impossible to delete id " + id + ", users table has child tables with information dependency");
		}
		catch ( RuntimeException e) {
			throw new GenericException(e.getMessage());
		}
		
	}
	
	public User update(Long id, User user) {
		
		try {		
			
			User aux = userRepository.getReferenceById(id);	
			
			aux.setEmail(user.getEmail());
			aux.setName(user.getName());
			aux.setPhone(user.getPhone());
			
			return userRepository.save(aux);
		
		}
		catch ( EntityNotFoundException e ) {			
			//throw new ResourceNotFoundException(id);
			throw new DatabaseException("Impossible update, ID " + id + " no found in database");
		}
		
		catch ( RuntimeException e ) {
			e.printStackTrace();
			throw new GenericException(e.getMessage());			
		}
	
		
	}
	
	
}
