package com.cadu172.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cadu172.workshopmongo.domain.Post;
import com.cadu172.workshopmongo.domain.User;
import com.cadu172.workshopmongo.repository.PostRepository;
import com.cadu172.workshopmongo.repository.UserRepository;

@Configuration
@Profile("dev")
public class DatabaseSeed implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com");		
		User user2 = new User(null, "Alex Green", "alex@gmail.com");
		User user3 = new User(null, "carlos", "cadu172@gmail.com");		
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", user1);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", user1);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
