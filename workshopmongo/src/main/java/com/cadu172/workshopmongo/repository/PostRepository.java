package com.cadu172.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cadu172.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase(String texto);
	
	@Query(value="{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String texto);
	
	List<Post> 

}
