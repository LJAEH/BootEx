package com.example.demo.hello;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.hello.repository.JpaUserRepository;
import com.example.demo.hello.repository.UserRepository;
import com.example.demo.hello.service.UserService;

import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {
	
	private final DataSource dataSource;
	
	private final EntityManager em;
	
	public SpringConfig(DataSource dataSource, EntityManager em) {
		this.dataSource = dataSource;
		this.em = em;
	}
	
	@Bean
	public UserService userService() {
		return new UserService(userRepository());
	}
	
	@Bean
	public UserRepository userRepository() {
		// return new MemoryMemberRepository();
		// return new JdbcMemberRepository(dataSource);
		// return new JdbcTemplateMemberRepository(dataSource);
		return new JpaUserRepository(em);
	}
}
