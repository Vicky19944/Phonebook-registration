package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.registration.entity.UnlockAcc;
import com.registration.entity.User;
import com.registration.service.ServiceImpl;

@Controller
public class UnlockAccountController {
	@Autowired
	private ServiceImpl serviceImpl;

	@GetMapping("/unlockAcc-form")
	public String getunlockAccForm(User u, Model model) {

		UnlockAcc unlockAc = new UnlockAcc();

		unlockAc.setEmail(u.getEmail());

		model.addAttribute("unlockAc", unlockAc);

		return "UnlockAccForm";

	}

	@PostMapping("/unlockAcc")
	public String unlockAccSubmitbtn(UnlockAcc acc, Model model, RedirectAttributes rd) {
		String unLockAcc = this.serviceImpl.unLockAcc(acc);
		rd.addFlashAttribute("unLockAcc", unLockAcc);
		return "redirect: UnlockAccForm";
	}

}
