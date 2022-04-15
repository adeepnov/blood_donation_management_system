package com.app.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "User_Table")
public class User {

	private int age;
	@Id
	private String email;
	private String username;
	private String password;
	private String mobile;
	private String blood_group;
	private String location;
	private String gender;
	private String available;

	
	@Override
	public String toString() {
		return "User [ age=" + age + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", mobile=" + mobile + ", blood_group=" + blood_group + ", location=" + location + ", gender="
				+ gender + ", available=" + available + "]";
	}

}
