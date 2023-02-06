package com.smhrd.myapp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smhrd.model.WebMember;
import com.smhrd.service.MemberService;

@Controller
public class MemberController {
	
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("/member/join")
	public String join(@ModelAttribute WebMember member, Model model) {
		// model -> service로 전달
		// 받아온 멤버 객체를 넘겨줌
		memberService.joinMember(member);
		model.addAttribute("joinM", member);
		return "joinSuccess";
	}
	
	@PostMapping("/member/login")
	public String login(@ModelAttribute WebMember member, HttpSession session) {
		WebMember loginM = memberService.loginMember(member);
		session.setAttribute("loginM", loginM);
		return "redirect:/main";
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginM");
		return "redirect:/main";
	}
	
	@PostMapping("/member/update")
	public String update(@ModelAttribute WebMember member, HttpSession session) {
		// 세션에서 값 가져오면 object타입으로 받아오므로 다운캐스팅 필요!
		WebMember loginM = (WebMember)session.getAttribute("loginM");
		//현재 로그인한 사용자의 이메일->현재 이 사용자의 정보만 수정
		String email = loginM.getEmail();
		member.setEmail(email); // 비워져 있는 email 필드 채우기
		
		// 아래들어가는 member는 email값까지 채워진 member
		memberService.updateMember(member);
		// 메인화면에 변경된 정보가 뜨도록 세션을 다시 설정해줌
		session.setAttribute("loginM", member);
		return "redirect:/main";
	}
	@GetMapping("/member/selectAllMember")
	public String selectAllMember(Model model) {
		List<WebMember> memberList = memberService.selectAllMember();
		model.addAttribute("memberList", memberList);
		return "selectMember";
	}
	
	// PathVariable : restAPI에서 URI에 변수가 들어가 있을 때 처리
	@GetMapping("/member/deleteMember/{email}")
	public String delete(@PathVariable("email") String email) {
		memberService.deleteMember(email);
		
		return "redirect:/member/selectAllMember";
	}
	
	
	
}
