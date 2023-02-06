package com.smhrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.mapper.MemberMapper;
import com.smhrd.model.WebMember;

// 데이터를 전달 받아서 가공하는 역할(POJO 형태로 전달)
@Service
public class MemberService {
	
	// controller -> service -> mapper
	
	@Autowired
	MemberMapper memberMapper;
	
	// 회원가입 Service 메소드 만들어주기
	public void joinMember(WebMember member) {
		//				컨트롤러에서 받아온 member 정보
		// 받아온데이터들 db에 삽입하도록 mapper로 넘겨줘야함 (
		memberMapper.joinMember(member);
	}
	
	// 로그인 Service
	public WebMember loginMember(WebMember member) {
		WebMember loginM = memberMapper.loginMember(member);
		return loginM;
	}
	
	// 정보수정 Service
	// 사용자가 변경할 멤버 객체를 넣어줌
	public void updateMember(WebMember member) {
		memberMapper.updateMember(member);
	}
	
	// 회원조회 Service
	public List<WebMember> selectAllMember() {
		List<WebMember> memberList = memberMapper.selectAllMember();
		return memberList;
	}
	
	// 회원삭제 Service
	public void deleteMember(String email) {
		memberMapper.deleteMember(email);
	}
	
}
