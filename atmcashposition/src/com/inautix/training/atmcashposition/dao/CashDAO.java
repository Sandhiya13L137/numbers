package com.inautix.training.atmcashposition.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inautix.training.atmcashposition.domain.Cash;
import com.inautix.training.atmcashposition.domain.Customer;

public class CashDAO {
	

public void createCashPosition(Cash cash){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		

		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");

			Statement stmt = con.createStatement();
			
String sql ="insert into cash_xbbnhfu values ("+cash.getNote()+","+cash.getAmount()+")";
//System.out.println("sql "+sql);			

stmt.execute(sql);
		
			con.commit();
			con.close();
		System.out.println("Cash record inserted successfully");
		}
		catch(Exception e){
			
			System.out.println(e);
		}
					
	}
	
	public List getAllCashPosition(){
		Connection con=null;
		List CashList = new ArrayList();
		Cash cash = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from cash_xbbnhfu order by NOTES");
			
			while(rs.next()) {
				cash = new Cash();
				cash.setNote(rs.getInt("NOTES"));
				cash.setAmount(rs.getInt("NUMOFNOTES"));
				CashList.add(cash);
			}
			con.commit();
		}
		catch(Exception e){
		}finally{
			try{
				
				con.close();
			}catch(Exception e){
				
			}
			
	}
		return CashList;}
	public Cash getCashDetails(int note) {
		
		Connection con = null;
		
		Cash cash = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			Statement stmt = con.createStatement();
			
			String sql = "select * from cash_xbbnhfu where notes="+note;
			System.out.println("SQL "+sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				cash = new Cash();
				cash.setAmount(rs.getInt("NUMOFNOTES"));
				cash.setNote(rs.getInt("NOTES"));
				
			}
			con.commit();

		}catch(Exception e){
			
		}finally{
			try{
				
				con.close();
			}catch(Exception e){
				
			}
		}

		return cash;
	}
	public List getCashDelete(int note ){
		Connection con = null;
		Cash cash = null;
		List CashList = new ArrayList();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(ClassNotFoundException e) {
				System.out.println(e);
			}
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			Statement stmt = con.createStatement();	
			String sql ="delete from cash_xbbnhfu where NOTES="+note;
			stmt.executeUpdate(sql);
			System.out.println("deleted sucessfully");
		
			ResultSet rs = stmt.executeQuery("select * from cash_xbbnhfu ");
			while(rs.next()) {
				cash = new Cash();
				cash.setNote(rs.getInt("NOTES"));
				cash.setAmount(rs.getInt("NUMOFNOTES"));
				CashList.add(cash);
			}
			con.commit();

			
		}catch(Exception e){
			
		}finally{
			try{
				
				con.close();
			}catch(Exception e){
				
			}
		}
		return CashList;
		}
	
		
public List getCashUpdate(int note , int amount){
	Connection con = null;
	Cash cash = null;
	List CashList = new ArrayList();
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}
	try{
		con=DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
		Statement stmt = con.createStatement();	
		String sql ="update cash_xbbnhfu set NUMOFNOTES="+amount+" where NOTES="+note;
		stmt.executeUpdate(sql);
		System.out.println("updated sucessfully");
	
		ResultSet rs = stmt.executeQuery("select * from cash_xbbnhfu ");
		while(rs.next()) {
			cash = new Cash();
			cash.setNote(rs.getInt("NOTES"));
			cash.setAmount(rs.getInt("NUMOFNOTES"));
			CashList.add(cash);
		}
		con.commit();

		
	}catch(Exception e){
		
	}finally{
		try{
			
			con.close();
		}catch(Exception e){
			
		}
	}
	return CashList;
	}
}

