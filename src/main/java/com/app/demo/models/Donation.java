package com.app.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Donation_Table")
public class Donation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  id;
	private String fullname;
	private String location;
	private String mobile;
	private float amount;
	
		
}