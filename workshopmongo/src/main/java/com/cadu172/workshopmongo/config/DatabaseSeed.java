package com.cadu172.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cadu172.workshopmongo.domain.User;
import com.cadu172.workshopmongo.repository.UserRepository;

@Configuration
@Profile("dev")
public class DatabaseSeed implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com");		
		User user2 = new User(null, "Alex Green", "alex@gmail.com");
		User user3 = new User(null, "carlos", "cadu172@gmail.com");		
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
	}

}
