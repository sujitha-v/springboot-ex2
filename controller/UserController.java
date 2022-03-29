package com.example.springbootcrudrestwebservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootcrudrestwebservices.entity.User;
import com.example.springbootcrudrestwebservices.exception.ResourceNotFoundException;
import com.example.springbootcrudrestwebservices.service.UserService;

@RestController
//@RequestMapping("/v1/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/all")
	public List<User> getUser()
	{
		return userService.getUserData();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value="id") long userId) {
		return userService.getUserDataById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("user not found with id:" +userId));
	}
	
	@PostMapping
	public User createUser(@Valid @RequestBody User user)
	{
		return userService.saveUser(user);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") long userId)
	{
		 User existingUserData=this.userService.getUserDataById(userId)
		 		.orElseThrow(()-> new ResourceNotFoundException("user not found with id" +userId));
		 existingUserData.setFname(user.getFname());
		 existingUserData.setLname(user.getLname());
	return this.userService.saveUser(existingUserData);
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long userId) {
		User existingUserData=this.userService.getUserDataById(userId)
		 		.orElseThrow(()-> new ResourceNotFoundException("user not found with id" +userId));
		userService.deleteUser(existingUserData);
		return ResponseEntity.ok().build();
		
	}
	
}
