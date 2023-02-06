package com.smhrd.myapp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smhrd.common.Criteria;
import com.smhrd.common.Page;
import com.smhrd.model.WebMember;
import com.smhrd.model.WebMessage;
import com.smhrd.service.MailService;

@Controller
public class MainController {
	// 페이지 보여주는 메서드들
	
	@Autowired
	MailService mailService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage(HttpSession session, Model model, Criteria cri) {
		// session은 object니까 다운캐스팅해주기
		WebMember loginM = (WebMember)session.getAttribute("loginM");
		
		if(loginM!=null) {
			// paging 전 버전
			// List<WebMessage> messageList = mailService.selectMail(loginM.getEmail());
			// model.addAttribute("messageList", messageList);
		
			// paging 추가 버전
			// 고른 페이지에서 보여줘야하는 메세지 리스트
			List<WebMessage> messageList = mailService.selectMailPaging(loginM.getEmail(), cri);
			
			int total = mailService.countMail(loginM.getEmail());
			// paging page 개수 -> Page
			Page page = new Page(cri, total);
			
			model.addAttribute("messageList", messageList);
			model.addAttribute("pagination",page);
		}
		return "main";
	}
	
	// update페이지 보여주는 메서드
	@GetMapping("/update")
	public String updatePage() {
		return "update";
	}
	
	
	
}
