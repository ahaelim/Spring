package com.smhrd.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// mainController 페이지 보여주는거 위주
// 컨트롤러들은 @Controller annotation 붙여줘야함! 
// 붙여주지 않으면 그냥 자바, 붙여주면 스프링 영향을 받는 중
// 컨트롤러 지정, Model 객체(데이터 저장) 만들기 + View 반환(String)
@Controller
public class MainController {
	
	// 요청을 받아줄 수 있는 메서드를 만들어주기
	// 메서드 써주면서 GET, POST방식 구분
	// 요청과 특정메서드 매핑
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String mainPage() {
		return "main"; // 파일 이름만 적어주면 resolve가 알아서 보내줌!
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinPage() {
		return "join";
	}
	
	// 5버전 이상부터 사용 (= requstmapping과 같은거)
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/update")
	public String updatePage() {
		return "update";
	}
	
	@GetMapping("/select")
	public String selectPage() {
		return "select";
	}
}
