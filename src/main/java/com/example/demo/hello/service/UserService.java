package com.example.demo.hello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.hello.domain.User;
import com.example.demo.hello.repository.UserRepository;

@Transactional
public class UserService {

	private final UserRepository repo;
	
	@Autowired
	public UserService(UserRepository repo) {
		this.repo = repo;
	}

	public String join(User user) {
		validateDuplicateUser(user);
		repo.save(user);
		return user.getId();
		
	}

	public void validateDuplicateUser(User user) {
		repo.findByName(user.getName())
		.ifPresent(m -> {
			 throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}
	
	public List<User> findUsers(){
		return repo.findAll();
	}
	
	public Optional<User> findOne(String id){
		return repo.findById(id);
	}

	public User login(User user) {

		return repo.login(user);
	}
	
	
}
