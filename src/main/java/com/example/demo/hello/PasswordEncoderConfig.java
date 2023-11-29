package com.example.demo.hello;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderConfig implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encodedPassword.equals(encode(rawPassword));
	}
	

}
