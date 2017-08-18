package com.inautix.training.atmcashposition.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.inautix.training.atmcashposition.domain.Customer;

public class CustomerDAO {
	public Customer getCostumerDetails(int cardnum ) {
		Connection con = null;
		Customer customer = null ;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			Statement stmt = con.createStatement();
			
			String sql ="select * from customer_201120 where CARDNUM="+cardnum;
			
			ResultSet rs = stmt.executeQuery(sql);
			
		

			while(rs.next()){
				
				customer = new Customer();
				customer.setPinnum(rs.getInt("PINNUM"));
				customer.setBalance(rs.getInt("BALANCE"));
				customer.setAccnum(rs.getInt("ACCNUM"));
				customer.setAcctype(rs.getString("ACCTYPE"));
				customer.setCusname(rs.getString("CUSNAME"));
				
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

		return customer;
	}
	
	public boolean getCostumerDetail(int cardnum ) {
		Connection con = null;
		Customer customer = null ;
		boolean authentication=false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			Statement stmt = con.createStatement();
			
			String sql ="select * from customer_201120 where CARDNUM="+cardnum;
			
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next() ) {
				authentication=true;
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

		return authentication;
	}

}
