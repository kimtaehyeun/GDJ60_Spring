package com.iu.s1.member;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	
	public int setMemberAdd(MemberDTO memberDTO) throws Exception{
		int result= memberDAO.setMemberAdd(memberDTO);
		result = memberDAO.setMemberRoleAdd(memberDTO);
		return result;
	}
	public List<MemberDTO> getMemberList() throws Exception {
		return memberDAO.getMemberList();
	}
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.getMemberLogin(memberDTO);
	}
	
	
}
