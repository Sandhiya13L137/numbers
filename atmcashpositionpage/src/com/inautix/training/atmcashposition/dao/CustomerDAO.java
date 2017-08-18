package com.inautix.training.atmcashposition.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inautix.training.atmcashposition.domain.Cash;
import com.inautix.training.atmcashposition.domain.Customer;

public class CustomerDAO {
	public Customer getCostumerDetails(int cardnum ) {
		Connection con = null;
		Customer customer = null ;
		//int pinnum=0;
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
				//pinnum=rs.getInt("PINNUM");
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
	
	public Customer getCustomerDetailForTransfer(int pAccNum ) {
		Connection con = null;
		Customer customer = null ;
		//int pinnum=0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			Statement stmt = con.createStatement();
			
			String sql ="select * from customer_201120 where ACCNUM="+pAccNum;
			
			ResultSet rs = stmt.executeQuery(sql);
			
		

			while(rs.next()){
				//pinnum=rs.getInt("PINNUM");
				customer = new Customer();
				customer.setPinnum(rs.getInt("PINNUM"));
				customer.setBalance(rs.getInt("BALANCE"));
				customer.setAccnum(rs.getInt("CARDNUM"));
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
	
	public boolean getAuthenticForTransfer(int accnum ) {
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
			
			String sql ="select * from customer_201120 where ACCNUM="+accnum;
			
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

	
	public Customer getBalanceUpdate(int cardnum , int balance){
		Connection con = null;
		Customer customer = null;
		//List CashList = new ArrayList();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(ClassNotFoundException e) {
				System.out.println(e);
			}
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			Statement stmt = con.createStatement();	
			String sql ="update customer_201120 set BALANCE="+balance+" where CARDNUM="+cardnum;
			stmt.executeUpdate(sql);
			System.out.println("updated sucessfully");
		
			ResultSet rs = stmt.executeQuery("select * from customer_201120 ");
			while(rs.next()) {
				customer = new Customer();
				customer.setBalance(rs.getInt("BALANCE"));
							}
			con.commit();
	
		}catch(Exception e){
			
		}finally{
			try{
				
				con.close();
			}catch(Exception e){
				
			}
		}
		return customer;
		}
	
	public Customer getWithdrawUpdate(int cardnum , int withdraw){
		Connection con = null;
		Customer customer = null;
		//List CashList = new ArrayList();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(ClassNotFoundException e) {
				System.out.println(e);
			}
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			Statement stmt = con.createStatement();	
			String sql ="update customer_201120 set WITHDRAW="+withdraw+" where CARDNUM="+cardnum;
			stmt.executeUpdate(sql);
			System.out.println("updated sucessfully");
		
			ResultSet rs = stmt.executeQuery("select * from customer_201120 ");
			while(rs.next()) {
				customer = new Customer();
				customer.setWithdraw(rs.getInt("WITHDRAW"));
							}
			con.commit();
	
		}catch(Exception e){
			
		}finally{
			try{
				
				con.close();
			}catch(Exception e){
				
			}
		}
		return customer;
		}
	
	public Customer getBalanceUpdateForTransfer(int accnum , int balance){
		Connection con = null;
		Customer customer = null;
		//List CashList = new ArrayList();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(ClassNotFoundException e) {
				System.out.println(e);
			}
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			Statement stmt = con.createStatement();	
			String sql ="update customer_201120 set BALANCE="+balance+" where ACCNUM="+accnum;
			stmt.executeUpdate(sql);
			System.out.println("updated sucessfully");
		
			ResultSet rs = stmt.executeQuery("select * from customer_201120 ");
			while(rs.next()) {
				customer = new Customer();
				customer.setBalance(rs.getInt("BALANCE"));
							}
			con.commit();
	
		}catch(Exception e){
			
		}finally{
			try{
				
				con.close();
			}catch(Exception e){
				
			}
		}
		return customer;
		}
	
	
	
	}


