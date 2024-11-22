package com.mbc.controller;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	
	public int insertWrite(BoardDTO dto);
	
	public BoardDTO selectOne(int num);
	
	public List<BoardDTO> selectAllList();
	
	public int deleteBoard(int num);
	
	public int updateBoard(BoardDTO dto);
	
}
