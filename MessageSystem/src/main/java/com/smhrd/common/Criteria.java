package com.smhrd.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 검색 기준 (1페이지에서 보여줄거, 2페이지에서 보여줄거 ..)
public class Criteria {
	private int pageNum; // 페이지 번호
	private int amount; // 한 페이지당 글 개수
	
	public Criteria() {
		//pageNum : 1  amount : 5
		//아래의 2개짜리 생성자가 호출이 됨
		this(1, 5);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
