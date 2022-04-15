package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.demo.models.Admin;


public interface Repository extends JpaRepository<Admin, String>{

}
