package com.users.usersmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.users.usersmanagement.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
