package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.registration.entity.User;
import com.registration.service.ServiceImpl;

public class UserRegistrationController {

	@Autowired
	private ServiceImpl serviceImpl;

	@GetMapping("/loadRegistrationForm")
	public String LoadRegisterForm(Model model) {

		User user = new User();
		model.addAttribute("RegistrationForm", user);

		return "RegistrationForm";
	}

	@PostMapping("/Save-user")
	public String handelSubmittBtn(User u, Model model) {
		String email = u.getEmail();
		User userByEmail = this.serviceImpl.getUserByEmail(email);

		boolean saveUser = this.serviceImpl.saveUser(userByEmail);
		if (saveUser) {
			this.serviceImpl.sendEmail(email);
			model.addAttribute("sucReg", "Please ckeck your registed email to unlock account");
		}

		return "UserAcc";
	}

	@PostMapping("/reset")
	public String handelResetBtn(Model model1) {

		User resetUser = new User();
		model1.addAttribute("resetUser", resetUser);

		return "RegistrationForm";

	}

}
