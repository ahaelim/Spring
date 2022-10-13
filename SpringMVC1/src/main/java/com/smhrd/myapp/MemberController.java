package com.smhrd.myapp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.mapper.MemberMapper;
import com.smhrd.model.Member;

// Controller=> Model(데이터), View 반환하는 역할
@Controller
public class MemberController {
	
	// 의존성 주입(DI) / membermapper를 외부에서 생성해서 주입시키고 바로 사용가능
	@Autowired
	private MemberMapper memberMapper;
	
	// post방식으로 요청했을때 작성@ 
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	
	// name이 id,pw,nick인 파라미터를 받아줌 (파라미터를 하나하나 따로따로 받아줄때)
	public String join(@RequestParam("id")String id, 
			@RequestParam("pw")String pw,
			@RequestParam("nick")String nick) {
		
		// 여기서 값이 넘어오는지 확인 => DB로 넘겨주기
		// System.out.println(id+", "+pw+", "+nick);
		
		Member member = new Member(id,pw,nick);
		memberMapper.joinMember(member);
		// joinMember는 반환 X (받을 것 X)
		
		return "main";
		
	}
	
	// ModelAttribute : object(객체)로 파라미터값을 받아줄때 (파라미터값을 하나로 묶어서 받아줄때)
	@PostMapping("/member/login")
	public String login(@ModelAttribute Member member, HttpSession session) {
		Member loginM = memberMapper.loginMember(member);
		session.setAttribute("loginM", loginM);
		return "main";
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginM");
		return "redirect:/main";
	}
	
	@PostMapping("/member/update")
	public String update(@ModelAttribute Member member, HttpSession session) {
		memberMapper.updateMember(member);
		session.setAttribute("loginM", member);
		return "redirect:/main";
	}
	
	// Model 객체 활용
	// Model : Controller에서 생성한 데이터를 담아서 view로 전달할 때 사용하는 객체
	@GetMapping("/member/select")
	public String select(Model model) {
		List<Member> memberList = memberMapper.selectAllMember();
		//컨트롤러에 가지고있는 전체회원정보를 jsp파일로 보내줘야함 => Model 객체 사용해서
		model.addAttribute("memberList", memberList); // model객체에 데이터 저장
		return "select";
	}
	
	@GetMapping("/member/delete")
	public String delete(@RequestParam("id")String id) {
		memberMapper.deleteMember(id);
		return "redirect:/member/select";
	}
	

	
}
