package com.example.demo.hello.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.hello.domain.User;

public interface MainRepository {
	User save(User user);
	Optional<User> findById(String id);
	Optional<User> findByName(String name);
	List<User> findAll();
	User login(User user);
	
}
