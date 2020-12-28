package com.example.LegalCrudApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LegalCrudApp.model.User;
import com.example.LegalCrudApp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> listAll(){
		return userRepository.findAll();
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public User get(int id) {
		return userRepository.findById(id).get();
	}
	public void delete(int id) {
		userRepository.deleteById(id);
	}

}
