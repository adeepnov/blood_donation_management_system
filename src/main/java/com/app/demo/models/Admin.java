package com.app.demo.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="Admin_table")
public class Admin {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Id
	private String username;
	private String password;
	private String email;
	private String mobile;
}

