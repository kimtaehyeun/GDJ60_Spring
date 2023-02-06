package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.product.ProductDTO;
import com.iu.s1.util.DBConnection;

@Repository
public class MemberDAO {
	
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnection.getConnection();
		String sql= "INSERT INTO MEMBER VALUES (?, ?, ?, ? ,?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
		st.setString(6, memberDTO.getAddress());
		int result = st.executeUpdate();
		DBConnection.disConnection(st, con);
		return result;
	}
	public List<MemberDTO> memberList() throws Exception{
		Connection con = DBConnection.getConnection();
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		String sql = "SELECT ID ,PW ,NAME ,ADDRESS FROM MEMBER";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString(1));
			memberDTO.setPw(rs.getString(2));
			memberDTO.setName(rs.getString(3));
			memberDTO.setAddress(rs.getString(4));
			ar.add(memberDTO);
		}
		return ar;
	}
}
