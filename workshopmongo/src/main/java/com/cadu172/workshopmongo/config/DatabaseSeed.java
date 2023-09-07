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
import com.cadu172.workshopmongo.dto.AuthorDTO;
import com.cadu172.workshopmongo.dto.CommentDTO;
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
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");		
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User carlos = new User(null, "carlos", "cadu172@gmail.com");		
		
		userRepository.saveAll(Arrays.asList(maria, alex, carlos));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(alex));
		
		CommentDTO coment1 = new CommentDTO("Boa Viagem Maria, assinado alex", sdf.parse("07/09/2023"), new AuthorDTO(alex));
		CommentDTO coment2 = new CommentDTO("Vai com Deus maria, assin carlos", sdf.parse("07/09/2023"), new AuthorDTO(carlos));
		CommentDTO coment3 = new CommentDTO("Vai na fé... assinado maria", sdf.parse("07/09/2023"), new AuthorDTO(maria));
		
		post1.getComments().addAll(Arrays.asList(coment1, coment2));
		post2.getComments().addAll(Arrays.asList(coment3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));		
		
		userRepository.save(maria);
		
	}

}
