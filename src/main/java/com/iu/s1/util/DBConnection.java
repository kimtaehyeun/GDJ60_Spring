package com.iu.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	//getConnection
	public static Connection getConnection() throws Exception {
		//1. �뿰寃곗?��蹂�
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@192.168.1.128:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. driver?���? 硫붾?��?��?�뿉 濡쒕�?
		Class.forName(driver);//?��몄옄�뿴濡� �맂寃껋?�� �겢�옒�뒪濡� 留뚮뱶�?�� �옉�뾽
		
		//3. DB�뿰寃�
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