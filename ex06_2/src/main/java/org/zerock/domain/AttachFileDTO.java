package org.zerock.domain;

import lombok.Data;

@Data
public class AttachFileDTO {

	private String fileName;   //원본파일이름
	private String uploadPath; //경로명
	private String uuid;       //uuid
	private boolean image;     //이미지 여부 판단
	
}
