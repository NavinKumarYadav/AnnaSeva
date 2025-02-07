package com.annaseva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annaseva.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String username);

}
