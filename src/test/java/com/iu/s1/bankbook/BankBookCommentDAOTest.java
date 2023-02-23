package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.util.Pager;

public class BankBookCommentDAOTest extends MyTestCase {

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	//List
	@Test
	public void getBoardListTest()throws Exception{
		Pager pager = new Pager();
		pager.setBookNumber(577L);
		long count = bankBookCommentDAO.getTotalCount(pager);
		assertNotEquals(0, count);
		
	}

}
