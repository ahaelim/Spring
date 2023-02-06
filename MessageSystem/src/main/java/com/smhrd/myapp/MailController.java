package com.smhrd.myapp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smhrd.model.WebMember;
import com.smhrd.model.WebMessage;
import com.smhrd.service.MailService;

@Controller
public class MailController {
	// 1. controller 메서드 작성
	// 2. mailservice 메서드 작성
	// 3. mailmapper 메서드 작성 - annotation
	
	@Autowired
	MailService mailService;
	
	//main의 sendMail과 매핑되어있는 메소드 만들어줌
	@PostMapping("/mail/sendMail")
	public String sendMail(@ModelAttribute WebMessage message) {
		mailService.sendMail(message);
		
		return "redirect:/main";
	}
	
	@GetMapping("mail/deleteAllMail")
	public String deleteAllMail(HttpSession session) {
		WebMember loginM = (WebMember)session.getAttribute("loginM");
		mailService.deleteAllMail(loginM.getEmail());
		return "redirect:/main";
	}
	
	@GetMapping("/mail/deleteMail/{num:.+}")
	public String deleteMail(@PathVariable("num") int num) {
		mailService.deleteMail(num);
		
		return "redirect:/main";
	}
	
	
}
