package com.app.demo.models;

import lombok.Data;

@Data
public class ResetPassword 
{
	private String oldpassword;
    private String newpassword;
    private String confirmpassword;
		
}
