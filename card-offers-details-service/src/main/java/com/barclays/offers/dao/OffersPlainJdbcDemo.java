package com.barclays.offers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
       
public class OffersPlainJdbcDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oms","root","root");
		
		String sp = "{ CALL oms.GET_OFFER_V1(?, ?, ?, ?, ?) }";
		
		CallableStatement cstmt = connection.prepareCall(sp); 
		
		cstmt.setString(1, "web");
		cstmt.setString(2, "online");
		cstmt.setString(3, "75639563829422146");
		cstmt.registerOutParameter(4, Types.VARCHAR);
		cstmt.registerOutParameter(5, Types.VARCHAR);
		
		cstmt.execute();
		ResultSet rs = cstmt.executeQuery();
		
		System.out.println("RespCode :" + cstmt.getString(4));
		System.out.println("RespMsg :" + cstmt.getString(5));

		
		while(rs.next())
		{
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));
			System.out.println(rs.getString(7));
			System.out.println(rs.getString(8));
			System.out.println(rs.getString(9));
			System.out.println(rs.getString(10));
			
		}
		
		
	}

}
