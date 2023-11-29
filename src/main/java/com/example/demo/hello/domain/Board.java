package com.example.demo.hello.domain;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Board {
		
	
	@Entity(name = "Board")
	@DynamicInsert
	public class User {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long board_cd;
		
		@Column
		private String topic;
		
		@Column
		private String content;
		
		@Column
		@CreationTimestamp
		private String date;
		
		@Column
		private int viewcount;
		
		@Column
		@ColumnDefault("0") // default
		private String state;
		
		@Column
		private String user_id;
	}

}
