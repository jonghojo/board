package com.mbc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MainClass {

	public static void main(String[] args)  {
		
		String resource = "com/mbc/controller/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			System.out.println("sqlSessionFactory : " + sqlSessionFactory);
			
			SqlSession session = sqlSessionFactory.openSession(true);//openSession(true)가 commit명령어 날리기를 해준다 없으면 rollback된다.
			
			System.out.println("session : " + session);
			
			BoardDTO dto = new BoardDTO();
			
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			/* 단건 조회
			dto = mapper.selectOne(112);
			System.out.println("dto : " + dto);
			*/
			
			
			/* 전체조회
			List<BoardDTO> lists = mapper.selectAllList();
			
			for(BoardDTO list : lists)
				System.out.println(lists);
			*/
			
			/*삭제
			int result = mapper.deleteBoard(112);
			System.out.println("result : " + result);
			*/
			
			dto.setTitle("마이바티스");
			dto.setContent("마이바티스 입력중...");
			dto.setNum(13);
			
			int result = mapper.updateBoard(dto);
			System.out.println("result 수정 : " + result);
			
			
//			dto.setNum(1000);
//			dto.setTitle("마이바티스");
//			dto.setContent("마이바티스 입력중...");
//			dto.setId("mybatis00");
//			dto.setVisitcount(0);
//			dto.setPostdate(new Date());
			
			//Blog blog = session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
