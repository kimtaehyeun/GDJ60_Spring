package com.iu.s1.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.qna.QnaDAO;
import com.iu.s1.util.Pager;

public class QnaDAOTest extends MyTestCase{

	@Autowired
	private QnaDAO qnaDAO;
	
	
	@Test
	public void getTotalCount() throws Exception{
		Pager pager = new Pager();
		long result= qnaDAO.getTotalCount(pager);
		assertNotEquals(0, result);
	}

}
