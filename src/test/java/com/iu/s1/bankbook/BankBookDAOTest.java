package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.util.Pager;

public class BankBookDAOTest extends MyTestCase {

	@Autowired
	private BankBookDAO bankBookDAO ;

//		@Test
	public void getBankBookList(Pager pager) throws Exception{
		List<BankBookDTO> ar = bankBookDAO.getBankBookList(pager);
		assertNotEquals(0, ar.size());
	}
//		@Test
	public void getBankBookDetail()throws Exception{

		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(42L);

		bankBookDTO=bankBookDAO.getBankBookDetail(bankBookDTO);
		assertNull(bankBookDTO);
	}
//	@Test
	public void setBankBookAdd()throws Exception{
		int result=0;
		for(int i =0; i<30; i++) {
			Random random = new Random();
			double d = random.nextDouble();
			int num = (int)(d*1000);
			d=num/100.0;
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("��������"+i);
		bankBookDTO.setBookRate(d);
		bankBookDTO.setBookSale(1);
		bankBookDTO.setBookDetail("q");
		result=bankBookDAO.setBankBookAdd(bankBookDTO);
		}
		assertEquals(1, result);
	}
	//	@Test
	public void setBankBookDelete()throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(43L);
		int i = bankBookDAO.setBankBookDelete(bankBookDTO);
		assertEquals(1, i);
	}

	//	@Test
	public void setBankBookUpdate()throws Exception{
		BankBookDTO bankBookDTO= new BankBookDTO();
		bankBookDTO.setBookNumber(231L);
		bankBookDTO.setBookName("d");
		bankBookDTO.setBookSale(1);
		bankBookDTO.setBookDetail("d");
		bankBookDTO.setBookRate(1.0);
		int i = bankBookDAO.setBankBookUpdate(bankBookDTO);
		assertEquals(1, i);

	}
}
