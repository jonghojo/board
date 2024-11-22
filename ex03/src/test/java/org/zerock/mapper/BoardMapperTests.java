package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(list->log.info(list));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	@Test
	public void testRead() {
		Long bno =2L;
		
		BoardVO boardVo = mapper.read(bno);
		log.info(boardVo);
	}
	
	@Test
	public void testDelete() {
		int result = mapper.delete(6L);
		
		log.info("result : " + result);
	}
	
	@Test
	public void testUpdate() {
		Long bno = 7L;
		BoardVO vo = mapper.read(bno);
		
		vo.setTitle("수정제목");
		vo.setContent("수정내용");
		vo.setWriter("수정자");
		
		int result = mapper.update(vo);
		log.info(result);
	}
	
	@Test
	public void testPaging() {
		Criterial cri = new Criterial(5,10);
		
		mapper.getListWithPaging(cri)
		.forEach(list -> log.info(list));;
	}
	
	
	@Test
	public void testSearch() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("T", "555");
		map.put("C", "4번째");
		map.put("W", "user00");
		
		Map<String, Map<String, String>> outer = new HashMap<>();
		
		outer.put("map", map);
		
		List<BoardVO> list = mapper.searchTest(outer);
		
		list.forEach(l -> log.info(l));
	}
	
	@Test
	public void testSearch2() {
		Criterial cri = new Criterial();
		
		cri.setKeyword("제목");
		cri.setType("TCW");
		
		mapper.getListWithPaging(cri)
		.forEach(list -> log.info(list));
	}
	
	@Test
	public void testTotalCount() {
		Criterial cri = new Criterial();
		
		cri.setKeyword("user00");
		cri.setType("TCW");
		
		int totalCount = mapper.getTotalCount(cri);
		
		log.info("totalCount : " + totalCount);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}