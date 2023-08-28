package com.users.usersmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.usersmanagement.Model.User;
import com.users.usersmanagement.repository.UserRepository;

@RestController
//@CrossOrigin("request port")
@RequestMapping(path = "api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository ;
	
	@GetMapping("helloWorld")
	String Hello() {
		return "Hello world";
		
	}
	
	@PostMapping
	User createUser (@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
	@GetMapping
	List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	Optional<User> getUserById(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@PutMapping("/{id}")
	Optional<User> updateUser(@RequestBody User newUser,@PathVariable Long id){
		return userRepository.findById(id).map(user -> {
			user.setUsername(newUser.getUsername());
			user.setName(newUser.getName());
			user.setEmail(newUser.getEmail());
			return userRepository.save(user);
		});
	}
	
	@DeleteMapping("/{id}")
	String deleteUser(@PathVariable Long id){
	  userRepository.deleteById(id);
	  return ("the "+id+" user hasbeen deleted succesfully!");
	}

}
