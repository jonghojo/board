package org.zerock.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testRegister() {
		
//		BoardVO vo = BoardVO.builder()
//				.title("새로 작성 하는 글")
//				.content("새로 작성하는 내용")
//				.writer("newbie01")
//				.build();
//		
//		service.register(vo);
//		
//		log.info("생선된 계시물의 번호 : " + vo.getBno());
	}
	
	@Test
	public void testGetList() {
//		List<BoardVO> list = service.getList();
//		list.forEach(vo -> log.info(vo));
		
//		service.getList().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void getRead() {
		log.info(service.get(8L));
	}
	
	@Test
	public void testDelete() {
		log.info("-------------------"+service.remove(8L));
		
	}
	
	@Test
	public void testModify() {
		BoardVO vo = service.get(7L);
		
		vo.setTitle("수정하는 제목");
		vo.setContent("수정하는 내용");
		vo.setWriter("수정하는 사람");
		
		log.info(service.modify(vo));
	}

}
