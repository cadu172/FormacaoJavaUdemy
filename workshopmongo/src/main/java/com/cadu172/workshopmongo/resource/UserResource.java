package com.cadu172.workshopmongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadu172.workshopmongo.domain.User;
import com.cadu172.workshopmongo.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired(required=true)
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		
		List<User> userArray = userService.findAll();
		
		return ResponseEntity.ok().body(userArray);			
				
	}

}
