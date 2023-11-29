package com.example.demo.hello.domain;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "User")
@DynamicInsert
public class User {
	
	@Id
	private String id;
	
	@Column
	private String name;
	
	@Column
	private String password;
	
	@Column
	@CreationTimestamp
	private String enroll_date;
	
	@Column
	@ColumnDefault("0") // default
	private String state;
	
    private User(String id, String password, String name, String enroll_date, String state) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.enroll_date = enroll_date;
        this.state = state;
    }

    public User() {}
	
	
    public static User createUser(String id
    		, String name
    		, String password
    		, PasswordEncoder passwordEncoder
    		, String enroll_date
    		, String state) {
        return new User(id, name, passwordEncoder.encode(password), enroll_date ,state);
    }
	

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
