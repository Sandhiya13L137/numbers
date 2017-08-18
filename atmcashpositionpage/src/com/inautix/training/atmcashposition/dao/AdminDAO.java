package com.inautix.training.atmcashposition.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.inautix.training.atmcashposition.domain.Admin;


public class AdminDAO {
	public Admin getAdminDetails(int id ) {
		Connection con = null;
		Admin admin = null ;
		//int pinnum=0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			Statement stmt = con.createStatement();
			
			String sql ="select * from admin_201120 where id="+id;
			
			ResultSet rs = stmt.executeQuery(sql);
			
		

			while(rs.next()){
				//pinnum=rs.getInt("PINNUM");
				admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setPin(rs.getInt("pin"));
				
				
			}
			con.commit();
		}catch(Exception e){
			System.out.println("Exception occured"+e);
			
		}finally{
			try{
				
				con.close();
			}catch(Exception e){
				
			}
		}

		return admin;
	}


}
