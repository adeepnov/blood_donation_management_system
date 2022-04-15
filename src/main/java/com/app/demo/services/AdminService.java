package com.app.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.models.Admin;
import com.app.demo.repository.DonationRepo;
import com.app.demo.repository.Repository;

@Service
public class AdminService 
{
	@Autowired
	Repository repo;
	
	
    
	public String checkLogin(Admin a)
	{
		String pageName=null;
		
		if(repo.existsById(a.getUsername()))
		{
			
			Admin admin=repo.getById(a.getUsername());
			
			if(a.getPassword().equals(admin.getPassword()))
			{
				System.out.println("loggedin");
				 pageName="adminloggedin.html";
				
			}
			else
			{
				System.out.println("Enter the correct password");
				 pageName="adminloginfailedforpassword.html";
			}
		}
		else
		{
			System.out.println("Enter correctusername");
			pageName="adminfailforusername.html"; 	
		}
		
	return pageName;
		
	}
	
	
	
}
