package com.iu.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	//getConnection
	public static Connection getConnection() throws Exception {
		//1. ï¿½ë¿°å¯ƒê³—? ™è¹‚ï¿½
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@192.168.1.114:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. driver?‘œï¿? ï§ë¶¾?ˆ?”±?Šë¿‰ æ¿¡ì’•ëµ?
		Class.forName(driver);//?‡¾ëª„ì˜„ï¿½ë¿´æ¿¡ï¿½ ï¿½ë§‚å¯ƒê»‹?“£ ï¿½ê²¢ï¿½ì˜’ï¿½ë’ªæ¿¡ï¿½ ï§ëš®ë±¶ï¿½?’— ï¿½ì˜‰ï¿½ë¾½
		
		//3. DBï¿½ë¿°å¯ƒï¿½
		return DriverManager.getConnection(url, user, password);
		
	}
	
	public static void disConnection(ResultSet rs, PreparedStatement st, Connection con)throws Exception{
		rs.close();
		st.close();
		con.close();
		
	}
	public static void disConnection(PreparedStatement st, Connection con)throws Exception{
	
		st.close();
		con.close();
		
	}

	
	/*
	public static void main(String[] args) {
		try {
			Connection con = DBConnection.getConnection();
			System.out.println(con !=null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/
}
