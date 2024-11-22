package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

@Service
public interface BoardService {

	public void register(BoardVO vo); //insert
	
	public BoardVO get(Long bno);//read
	
	public boolean modify(BoardVO vo);//update
	
	public boolean remove(Long bno);//delete
	
//	public List<BoardVO> getList();

	public List<BoardVO> getList(Criterial cri);
	
	public int getTotal(Criterial cri);
}
