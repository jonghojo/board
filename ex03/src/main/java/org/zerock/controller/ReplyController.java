package org.zerock.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criterial;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies/")
@Log4j
@RequiredArgsConstructor
public class ReplyController {
	
	private final ReplyService service;
	
	//추가하기
	//http://localhost:8080/replies/new -> json데이터를 replyvo객체로 convert 후 DB저장
	//저장 성공이면 ResponseEntity에 "success" 문자열과 상태코드(200)을 응답해준다.
	//실패면 ResponseEntity에 상태코드(500)을 응답해준다.
	@PostMapping(value = "/new", 
			consumes = MediaType.APPLICATION_JSON_VALUE, //요청(json)
			produces = MediaType.TEXT_PLAIN_VALUE //응답(String)
			) 
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("create....." + vo);
		
		int insertCount = service.register(vo);
		
		return insertCount ==1 
				? new ResponseEntity<String>/*문자열이고 Entity->상태 코드값*/("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	};
	
	
	//특정 게시물의 댓글 목록 확인하기
	//http://localhost:8080/replies/pages/18/1 => reply테이블에서 bno가 18번인 전체 레코드 중 1페이지에 해당하는 10개 가져오기
	@GetMapping(value = "/pages/{bno}/{page}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(
			@PathVariable("bno") Long bno,
			@PathVariable("page") int page
			){
		
		log.info("getList..........bno : " + bno +", page : " + page);
		Criterial cri = new Criterial(page, 10);

//		List<ReplyVO> list = service.getList(cri, bno);
		ReplyPageDTO list = service.getListPage(cri, bno);
		
		log.info("-------------------------------");
		log.info("list : " + list);
		
		return new ResponseEntity<ReplyPageDTO>(list, HttpStatus.OK);
	}
	
	//http://localhost:8080/replies/34 => reply테이블에서 rno가 34에 해당하는 객체 삭제하기
	//삭제 성공이면 ResponseEntity에 "success" 문자열과 상태코드(200)을 응답해준다.
	//실페면 ResponseEntity에 상태코드(500)을 응답해준다.
	@DeleteMapping(value = "/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno")Long rno){
		log.info("remove.........." + rno);
		
		return service.remove(rno) ==1
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//http://localhost:8080/replies/13 => reply테이블에서 13번 레코드를 json으로 응답한다.
	@GetMapping(value = "/{rno}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){
		
		log.info("get............" + rno);
		
		ReplyVO replyVO = service.get(rno);
		
		return new ResponseEntity<ReplyVO>(replyVO, HttpStatus.OK);
	}
	
	//http://localhost:8080/replies/13 + json데이터 => rno(13)번 수정한다.
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
			value = "/{rno}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.TEXT_PLAIN_VALUE}
	)
	public ResponseEntity<String> modify(
			@PathVariable("rno") Long rno,
			@RequestBody ReplyVO vo
			){
		
		vo.setRno(rno);
		
		log.info("modify......... rno : " + rno + ", reply : " + vo);
		
		return service.modify(vo) == 1 
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}






































