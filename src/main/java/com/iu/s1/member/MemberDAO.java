package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.product.ProductDTO;
import com.iu.s1.util.DBConnection;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESAPCE="com.iu.s1.member.MemberDAO.";
	
	public int setMemberAdd(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESAPCE+"setMemberAdd", memberDTO );
	}
	
	
	public List<MemberDTO> getMemberList() throws Exception{
		return sqlSession.selectList(NAMESAPCE+"getMemberList");
	}
	public int setMemberRoleAdd(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESAPCE+"setMemberRoleAdd",memberDTO);
	}
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESAPCE+"getMemberLogin", memberDTO);
	}
	public int setmemberUpdate(MemberDTO memberDTO)throws Exception{
		return sqlSession.update(NAMESAPCE+"setMemberUpdate",memberDTO);
	}
	
}
