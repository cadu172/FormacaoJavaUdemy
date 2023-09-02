package com.cadu172.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cadu172.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
