package com.iu.s1.member;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class MemberDAOTest extends MyTestCase{
	@Autowired
	private MemberDAO memberDAO;


//		@Test
		public void getMemberList() throws Exception{
			List<MemberDTO> ar =	memberDAO.getMemberList();
			assertNotEquals(0, ar.size());
		}
//	@Test
//	public void setMemberJoinList() throws Exception{
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId("ads123");
//		memberDTO.setPw("asdfbbb");
//		memberDTO.setName("rasdddd");
//		memberDTO.setPhone("ffffff");
//		memberDTO.setAddress("dfasdfasdfbb");
//		memberDTO.setEmail("asfsadfsadf");
//		int i =memberDAO.setMemberJoin(memberDTO);
//		assertEquals(1, i);
//	}
//		@Test
		public void getMemberLogin()throws Exception{
			MemberDTO memberDTO2 = new MemberDTO();
			memberDTO2.setId("ads12345");
			memberDTO2.setPw("asdfbbb");
			memberDTO2=memberDAO.getMemberLogin(memberDTO2);
			assertNotNull(memberDTO2);
			
		}
//		@Test
		public void setMemberUpdate() throws Exception{
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setName("rasdddd");
			memberDTO.setPhone("ffffff");
			memberDTO.setAddress("dfasdfasdfbb");
			memberDTO.setEmail("asfsadfsadf");
			memberDTO.setId("dd");
			int i =memberDAO.setmemberUpdate(memberDTO);
			assertEquals(1, i);
		}
}
