package com.smhrd.mapper;

import java.util.List;

import com.smhrd.model.Member;

public interface MemberMapper {
	//mybatis 특징 : 하나로 묶어서 보내고 하나로 묶어서 꺼내줘야함 => 인터페이스 생성
	public void joinMember(Member member);
	
	public Member loginMember(Member member);
	
	public void updateMember(Member member);
	
	public List<Member> selectAllMember();
	
	public void deleteMember(String id);
	
	
}
