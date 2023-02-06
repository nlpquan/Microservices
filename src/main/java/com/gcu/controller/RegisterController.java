package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.SecurityService;
import com.gcu.business.UsersBusinessService;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	UserModel userModel = new UserModel();
	
	@Autowired
	UsersBusinessService usersBusinessService;
	
	@Autowired
	SecurityService securityService;

	@GetMapping("")
	/**
	 * This method shows the register view
	 * @param model model
	 * @return register view
	 */
	public String displayRegister(Model model) {
		model.addAttribute("userModel", userModel);
		return "register";
	}
	
	
	@PostMapping("")
	/**
	 * This method is called when register form is sent
	 * @param userModel user model
	 * @param bindingResult binding result
	 * @param model model
	 * @return register view or dashboard view
	 */
	public String registered(@Valid UserModel userModel, BindingResult bindingResult, Model model) {
		
		if(usersBusinessService.verifyUsername(userModel) == 1) {
			bindingResult.rejectValue("credentials.username", "error.username", "Username already exists");
		
		}
		
		if(usersBusinessService.verifyEmail(userModel) == 1) {
			bindingResult.rejectValue("email", "error.email", "Email already exists");
		}
		
		
		if(bindingResult.hasErrors()) {
			return ("/register");
		}
		
		
		usersBusinessService.createUser(userModel);
		
		this.userModel.setFirstName(userModel.getFirstName());
		this.userModel.setLastName(userModel.getLastName());
		this.userModel.credentials.setUsername(userModel.credentials.getUsername());
		this.userModel.credentials.setPassword(userModel.credentials.getPassword());
		this.userModel.setEmail(userModel.getEmail());
		return ("redirect:/dashboard");
	}
	
}

