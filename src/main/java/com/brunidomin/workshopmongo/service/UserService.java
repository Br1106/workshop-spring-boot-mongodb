package com.brunidomin.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunidomin.workshopmongo.domain.User;
import com.brunidomin.workshopmongo.dto.UserDTO;
import com.brunidomin.workshopmongo.repository.UserRepository;
import com.brunidomin.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public User fromUser(UserDTO objDTO) {
		return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
	}
}
