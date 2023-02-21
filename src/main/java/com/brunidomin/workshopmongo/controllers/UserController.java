package com.brunidomin.workshopmongo.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brunidomin.workshopmongo.domain.Post;
import com.brunidomin.workshopmongo.domain.User;
import com.brunidomin.workshopmongo.dto.UserDTO;
import com.brunidomin.workshopmongo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity <List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity <UserDTO> findByid(@PathVariable String id){
		User user = service.findById(id);			
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@PostMapping
	public ResponseEntity <Void> insert(@RequestBody UserDTO objDTO){
		User obj = service.fromUser(objDTO);
		obj = service.insert(obj);
		
		// Retorna após uma inserção a URI contendo o ID do USER no corpo da requisição
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity <Void> update(@RequestBody UserDTO objDTO,@PathVariable String id){
		User obj = service.fromUser(objDTO);
		obj.setId(id);// Garantir o msm ID do corpo da requisição
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
/*-----------------------------------------------------------------------------------------------------------------------*/
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity <List<Post>> findPosts(@PathVariable String id){
		User user = service.findById(id);			
		return ResponseEntity.ok().body(user.getPosts());
	}
}
