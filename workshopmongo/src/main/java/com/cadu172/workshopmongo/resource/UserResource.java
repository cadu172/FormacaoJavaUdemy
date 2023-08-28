package com.cadu172.workshopmongo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody UserDTO userDTO) {
		
		// converte UserDTO em User comum
		User user = userService.userFromDTO(userDTO);
		
		// inserir usuário e obter id
		user = userService.insert(user);
		
		/* gera a URL que será retornada pela API apos o processo de POST, 
		 * permitindo que o front-end possa usar o link para uma consulta posterior
		 * Obs: A URL é retornada no HEADER da resposta no item "Location"
		 */
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(location).body(user);		
	}

}
