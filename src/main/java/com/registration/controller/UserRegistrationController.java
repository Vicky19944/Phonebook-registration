      package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.registration.entity.User;
import com.registration.service.ServiceImpl;

public class UserRegistrationController {

	@Autowired
	private ServiceImpl serviceImpl;

	

	@PostMapping("/Save-user")
	public String handelSignUpSubmittBtn(User u, RedirectAttributes rd) {
		String email = u.getEmail();
		User userByEmail = this.serviceImpl.getUserByEmail(email);

		boolean saveUser = this.serviceImpl.saveUser(userByEmail);
		if (saveUser) {
			this.serviceImpl.sendEmail(email);
			rd.addFlashAttribute("sucReg", "Please ckeck your registed email to unlock account");
		}

		return "redirect:RegistrationForm";
	}

	@PostMapping("/reset")
	public String handelResetBtn(Model model1) {

		User resetUser = new User();
		model1.addAttribute("resetUser", resetUser);

		return "RegistrationForm";

	}

}
