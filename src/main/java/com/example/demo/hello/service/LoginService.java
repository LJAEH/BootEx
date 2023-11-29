package com.example.demo.hello.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.hello.domain.User;



@Component
public class LoginService implements UserDetailsService{
	
	private final UserService service;

	public LoginService(UserService service) {
		this.service = service;
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Optional<User> findOne = service.findOne(userId);
		User user = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));
		System.out.println(user.getId());
		System.out.println(user.getName());
		
		return org.springframework.security.core.userdetails.User.builder()
                .username(user.getId())
                .password(user.getPassword())
                .build();
	}
	
	
	

}
