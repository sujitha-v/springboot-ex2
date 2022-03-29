package com.example.springbootcrudrestwebservices.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootcrudrestwebservices.entity.User;
import com.example.springbootcrudrestwebservices.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	User user;

	public List<User> getUserData() {
		return userRepository.findAll();
	}

	public Optional<User> getUserDataById(long id) {
		return userRepository.findById(id);
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(User user) {

		 userRepository.delete(user);
	}

}
