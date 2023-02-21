package com.brunidomin.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brunidomin.workshopmongo.domain.Post;
import com.brunidomin.workshopmongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
