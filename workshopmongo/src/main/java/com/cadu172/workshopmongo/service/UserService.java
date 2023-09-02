package com.cadu172.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadu172.workshopmongo.domain.User;
import com.cadu172.workshopmongo.dto.UserDTO;
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
	
	public User userFromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
	
	public User insert(User user) {
		
		return userRepository.insert(user);
		
	}
	
	public void deleteById(String id) {
		userRepository.deleteById(id);		
	}
	
	public User update(User user) {
		
		//User userdb = this.findById(user.getId());		
		// atualizar o id do objeto pa
		//user.setId(userdb.getId());
		
		if ( user.getId()==null ) {
			throw new ResourceNotFoundException("Operacao update obrigatorio informar o id");
		}
		else if ( user.getEmail() == null  ) {
			throw new ResourceNotFoundException("Operacao update obrigatorio informar o campo email");
		}
		else if ( user.getName() == null  ) {
			throw new ResourceNotFoundException("Operacao update obrigatorio informar o campo name");
		}
		
		
		return userRepository.save(user);
	
	}
	
}
