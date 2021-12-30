package com.greatlearning.EmployeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.model.User;
import com.greatlearning.EmployeeManagement.repository.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	UserRepository userRepository;

	public User setUser(User user) {
		return userRepository.save(user);
	}

}
