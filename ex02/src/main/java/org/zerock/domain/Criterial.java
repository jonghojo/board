package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criterial {

	private int pageNum; //페이지 번호
	private int amount;  //화면당 레코드 개수
	
	private String type; //제목 or 내용 or 저자
	private String keyword; //검색어
	
	public Criterial() {
		this(1,10); //1페이지 당 10개의 개시물
	}
	
	public Criterial(int pageNum, int amount) {
		this.amount = amount;
		this.pageNum = pageNum;
	}
	
	/*
	 * T : 제목
	 * C : 내용
	 * W : 저자
	 * TCW(제목,내용,저자), TW(제목,저자), TC(제목, 내용), CW(내용, 저자)
	 */
	
	//type 검색 조건을 분리! TCW -> T | C | W 개별적으로 분리
	public String[] getTypeArr() {
		return type==null? new String[] {}: type.split("");
	}
}
