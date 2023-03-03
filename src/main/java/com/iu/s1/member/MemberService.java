package com.iu.s1.member;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public boolean getMemberIdCheck(MemberDTO memberDTO) throws Exception{
		memberDTO=memberDAO.getMemberLogin(memberDTO);
		boolean check= true;// 중복이 아니면 true
		if(memberDTO != null) {		//null 이 아니면 중복이다.
			check = false;
		}
		return check;
	}
	
	public int setMemberAdd(MemberDTO memberDTO) throws Exception{
		int result= memberDAO.setMemberAdd(memberDTO);
		result = memberDAO.setMemberRoleAdd(memberDTO);
		return result;
	}
	public List<MemberDTO> getMemberList() throws Exception {
		return memberDAO.getMemberList();
	}
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception{
		//memberDTO : Client 에서 입력한 id pw
		MemberDTO  result =memberDAO.getMemberLogin(memberDTO);
		//result : id 와 일치하는 모든정보
		
		//pw check
		if(result != null &&memberDTO.getPw().equals(result.getPw())) {
			memberDTO.setPw(null);
			memberDTO.setRoleDTO(result.getRoleDTO());
			return memberDTO;
		}
		else {
			return null;
		}
		
	}
	public MemberDTO getMemberPage(MemberDTO memberDTO) throws Exception{
		return memberDAO.getMemberLogin(memberDTO);
	}
	public int setMemberUpdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.setmemberUpdate(memberDTO);
	}
	
}
