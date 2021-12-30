package com.greatlearning.EmployeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.model.Role;
import com.greatlearning.EmployeeManagement.repository.RoleRepository;

@Service
public class RoleServiceImpl {

	@Autowired
	RoleRepository roleRepository;

	public void addRole(String name) {
		roleRepository.save(new Role(name));
	}
}
