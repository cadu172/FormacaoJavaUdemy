package com.cadu172.workshopmongo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadu172.workshopmongo.domain.User;
import com.cadu172.workshopmongo.dto.UserDTO;
import com.cadu172.workshopmongo.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired(required=true)
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> userArray = userService.findAll();
		List<UserDTO> userArrayDTO = userArray.stream().map(item -> new UserDTO(item)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(userArrayDTO);		
				
	}
	
	@GetMapping(value="/{id}")	
	public ResponseEntity<UserDTO> findByid(@PathVariable String id) {
		
		User user = userService.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(user));		
				
	}	

}
