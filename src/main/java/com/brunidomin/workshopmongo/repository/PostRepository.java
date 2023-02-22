package com.brunidomin.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brunidomin.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	//Método de Query 
	List<Post> findByTitleContainingIgnoreCase(String text);
}			 //------title	
			 //-----------Contendo
			 //---------------------IgnorandoCase