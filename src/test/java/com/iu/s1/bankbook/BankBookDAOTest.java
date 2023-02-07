package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class BankBookDAOTest extends MyTestCase {

	@Autowired
	private BankBookDAO bankBookDAO ;

//	@Test
	public void getBankBookList() throws Exception{
		List<BankBookDTO> ar = bankBookDAO.getBankBookList();
		assertNotEquals(0, ar.size());
	}
//	@Test
	public void getBankBookDetail()throws Exception{

		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(42L);
		
		bankBookDTO=bankBookDAO.getBankBookDetail(bankBookDTO);
		assertNull(bankBookDTO);
	}
@Test
	public void setBankBookAdd()throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(43L);
		bankBookDTO.setBookName("ad");
		bankBookDTO.setBookRate(1.5);
		bankBookDTO.setBookSale(1);
		bankBookDTO.setBookDetail("q");
		int i=bankBookDAO.setBankBookAdd(bankBookDTO);
		assertEquals(1, i);
	}
}
