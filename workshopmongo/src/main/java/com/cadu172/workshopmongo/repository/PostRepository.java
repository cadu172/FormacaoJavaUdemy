package com.cadu172.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cadu172.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase(String texto);
	
	@Query(value="{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String texto);
	
	
	@Query(value="{ $and: "
			+ "  [ "
			+ "    { date: {$gte: ?1} },"
			+ "    { date: {$lte: ?2} },"
			+ "    { $or: [ { 'title': { $regex: ?0, $options: 'i' } },"
			+ "             { 'body': { $regex: ?0, $options: 'i' } },"
			+ "             { 'comments.text': { $regex: ?0, $options: 'i' } }"
			+ "           ]} "
			+ "  ]}")	
	List<Post> fullSearch(String texto, Date dataInicial, Date dataFinal);

}
