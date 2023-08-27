package com.cadu172.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cadu172.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
