package com.brunidomin.workshopmongo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunidomin.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping
	public ResponseEntity <List<User>> findAll(){
		List<User> list = new ArrayList<>();
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		list.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(list);
	}
	
}
