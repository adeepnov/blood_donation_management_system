package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.demo.models.Donation;

public interface DonationRepo extends JpaRepository<Donation, Long>
{
	

}
