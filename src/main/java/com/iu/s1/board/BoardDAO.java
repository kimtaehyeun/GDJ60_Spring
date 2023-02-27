package com.iu.s1.board;

import java.util.List;

import com.iu.s1.util.Pager;

public interface BoardDAO extends BbsDAO{
	//extends BbsDAO
	//list
	//insert
	
	//fileAdd
	public int setBoardFileAdd(BoardFileDTO boardFileDTO) throws Exception;
	
	//update
	//delete

	//detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO)throws Exception;
	
	//BoardFileList
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO) throws Exception;



}
