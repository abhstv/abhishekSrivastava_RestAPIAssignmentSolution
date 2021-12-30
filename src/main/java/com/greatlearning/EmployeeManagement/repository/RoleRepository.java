package com.greatlearning.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.EmployeeManagement.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}