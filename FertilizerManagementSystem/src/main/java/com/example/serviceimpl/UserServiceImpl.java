package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;

	public User findUserByUsername(String username, String password) {

		User user = userRepository.findByUsername(username);

		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	public void saveUser(User user) {

		this.userRepository.save(user);
	}

	public List<User> getAllUsers() {

		return this.userRepository.findAll();

	}
}
