package com.app.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.demo.models.User;
import com.app.demo.repository.UserRepo;
import com.app.demo.services.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userservice;

	@Autowired
	UserRepo userrepo;

//----------------------------------------------------------------------------------------------
	@RequestMapping("/register")
	public String getRegistrationForm(Model m) {
		User user = new User();
		m.addAttribute("users", user);
		return "Registeruser.html";
	}

//----------------------------------------------------------------------------------------------
	@RequestMapping("/saveuser")
	public String successPage(@ModelAttribute("users") User u) {
		String p = userservice.saveUser(u);
		return p;
	}

//----------------------------------------------------------------------------------------------
	@RequestMapping("/saveafterupdate")
	public String saveUpdateduser(@ModelAttribute("users") User u) {
		userrepo.save(u);
		return "success.html";
	}

//----------------------------------------------------------------------------------------------
	@RequestMapping("/userlogin")
	public String userLoginPage(Model m) {
		User user = new User();
		m.addAttribute("user", user);
		// to bind data for this plain pojo object
		return "userlogin.html";
	}

//----------------------------------------------------------------------------------------------	
	@RequestMapping("/checkuserLogin")
	public String checkUserLogin(@ModelAttribute("user") User u) {
		String page = userservice.checklogin(u);
		return page; // userafterlogin.html
	}

//----------------------------------------------------------------------------------------------	
	@RequestMapping("/forgotpassword")
	public String forgetUserPassword(Model m) {
		User user = new User();
		m.addAttribute("forgotdetails", user);
		return "userforgot.html";

	}

//----------------------------------------------------------------------------------------------
	@RequestMapping("/userforgotpasscheck")
	public String forgotPassCheck(@ModelAttribute("forgotdetails") User u, Model model)
	{
	    User user = userservice.check(u);
	    if(user == null)
	    	return "invalidphone.html";
	    model.addAttribute("newpswddetails",user);
		return "message.html";
		
	}
	
//----------------------------------------------------------------------------------------------
		@RequestMapping("/generatenewpswd")
		public String createnewpswd(@ModelAttribute("newpswddetails") User u, Model model) {
			
			
			String msg = userservice.setNewPswd(u);
			model.addAttribute("message", msg);
			return "newPswdUpdated";
		}

//----------------------------------------------------------------------------------------------
	@RequestMapping("/deleteuser/{email}")
	public String deleteuserformtable(@PathVariable(value = "email") String email) {
		this.userservice.deleteUser(email);
		return "redirect:/displayusers";

	}
////----------------------------------------------------------------------------------------------	

	@GetMapping("/updateuser/{email}")
	public ModelAndView updateTheUser(@PathVariable(value = "email") String email) {
		ModelAndView mv = new ModelAndView("userupdateform");

		User user = userrepo.getById(email);

		// set User as a Model Attribute to Pre-Populate the form
		mv.addObject("users", user);
		return mv;

	}
//=================================================================================================

	@GetMapping("/updatespecificuser/{username}")
	public ModelAndView updateSpecificUser(@PathVariable(value = "username") String username) {
		ModelAndView mv = new ModelAndView("userupdateform");

		User user = userrepo.getById(username);

		// set User as a Model Attribute to Pre-Populate the form
		mv.addObject("users", user);
		return mv;

	}

//================================================================================

	@RequestMapping("/searchdonor")
	public String searchpage(Model m) {
		User user = new User();
		m.addAttribute("user", user);
		return "searchbybloodgrplist.html";
	}
//====================================================================================

	@RequestMapping("/searching")
	public String getByBgroup(@RequestParam String blood_group, Model model) {

		System.out.println(blood_group);
		List<User> user = userservice.getByBloodGroup(blood_group);
		model.addAttribute("users", user);
		return "listresult.html";

	}
//========================================================================================

	@RequestMapping("/users")
	public String getUsers(Model m) {
		// User user = userrepo.getById(null);
		m.addAttribute("users", userrepo.findAll());
		return "viewusers.html";
	}

//=========================================================================================
	
	@RequestMapping("/searching1")
	public String getBylocation(@RequestParam String location ,Model model)
	{
		System.out.println(location);
		List<User> user=userservice.getByLocation(location);
        model.addAttribute("users", user);
    	return "listresult.html";
		
	}
	
}
