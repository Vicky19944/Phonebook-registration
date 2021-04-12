package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.registration.entity.User;
import com.registration.service.ServiceImpl;

@Controller
public class UserLoginController {

	@Autowired
	private ServiceImpl serviceImpl;

	@GetMapping("/Sign-in")
	public String loadSignInForm(Model model) {

		User user = new User();
		model.addAttribute("SignInUser", user);

		return "SignIn-form";
	}

	@PostMapping("/SignIn/{email}/{password}")
	public String handelSignInBttn(@PathVariable("email")String email, @PathVariable("password")String password, RedirectAttributes rd) {
		String cheackSignIn = serviceImpl.cheackSignIn(email, password);
		if (cheackSignIn != null) {

			if (cheackSignIn == "succcsess") {
				rd.addFlashAttribute("logInSuccMsg", "wellcome to Ashoke It");
			}
			if (cheackSignIn == "invalid") {
				rd.addFlashAttribute("invalidCredintial", "Invalid Credintial");

			}
			if (cheackSignIn == "locked") {
				rd.addFlashAttribute("locked", "User Account is Locked");
			}
		}
		return "redirect:SignIn-form";

	}

	@PostMapping("/forgotPassword")
	public String handelForgotPaswordHyperLink() {

		return "forgotPasswordForm";
	}

	public String handelSignUpLink(Model model) {
		User user = new User();

		model.addAttribute("SignUpUser", user);

		return "SignUpUser";
	}

}
