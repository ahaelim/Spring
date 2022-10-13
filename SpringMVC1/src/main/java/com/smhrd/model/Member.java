package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;

// 테이블 먼저 생성 후에 클래스 생성하기
// 테이블 명, 컬럼명 동일하게 해줘야함

@AllArgsConstructor
@Data
public class Member {
	private String id;
	private String pw;
	private String nick;
	
	// 전체파라미터 생성자
	// 기본생성자 (@ModelAttribute 용)
	// setter
	// getter
	
	
}


