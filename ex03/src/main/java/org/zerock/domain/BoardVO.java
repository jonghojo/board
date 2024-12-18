package org.zerock.domain;
/*
 * create table tbl_board(
    bno number (10,0),
    title varchar2(200) not null,
    content varchar2(2000) not null,
    writer varchar2(50) not null,
    regate date default sysdate,
    updatedate date default sysdate
);
 */

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
//@Builder
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regate;
	private Date updateDate;
}
