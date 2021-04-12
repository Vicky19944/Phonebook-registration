package com.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.registration.entity.User;
import com.registration.service.ServiceImpl;

@Controller
public class ForgotPasswordController {
	
	private ServiceImpl serviceImpl;
	
	public ForgotPasswordController(ServiceImpl serviceImpl) {
		super();
		this.serviceImpl = serviceImpl;
	}

	
     
@PostMapping("/getforgotenPassword/{emailId}")
	public String SubmitForgotBtn(@PathVariable("emailId") String emailId, RedirectAttributes rd) {
		User user=this.serviceImpl.getUserByEmail(emailId);
		if(user!=null) {
		User forgotPassword = this.serviceImpl.forgotPassword(emailId);
		rd.addFlashAttribute("SuccMsg-forgotpassword", "Succcessfully password is sended to this email");
		}
		else {
			rd.addFlashAttribute("ErrorMsg-forgotpassword", "Invalid email please try again with correct email");
		}
		return "redirect:forgotPasswordForm";
	}
}
