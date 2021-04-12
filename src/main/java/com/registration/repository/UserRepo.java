package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registration.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.email    = ?1")
	public User findByEmail(String email);

	
}
