package com.inautix.training.courier.dao;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inautix.training.courier.domain.Clients;
import com.inautix.training.courier.domain.Employees;
public class ClientDAO {
	public static void createClient(Clients clients)
	{
		Connection con=null;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	catch(ClassNotFoundException e) 
	{
		System.out.println(e);
	}
	try {
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
		Statement stmt = con.createStatement();
		
		String sql ="insert into CLIENT_XBBX2 values ("+clients.getid()+",'"+clients.getname()+"'"+",'"+clients.getdate()+"','"+clients.getpassword()+"',"+"'"+clients.getaddress()+"','"+clients.getaddress2()+"')";
				
		System.out.println("sql "+sql);
	stmt.execute(sql);

		con.commit();
		con.close();
	System.out.println("Client record inserted successfully");
	}
	catch(Exception e){
		
		System.out.println("Exception occurred"+e);
	}
	finally{
		try{
		con.close();}
		catch(Exception e)
		{
			
		}
	}
	}


public static List getAllClients(){
	Connection con=null;
	List ClientList = new ArrayList();
	Clients client = null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}catch(ClassNotFoundException e) {
		System.out.println(e);
	}

	try {
		con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");

		Statement stmt = con.createStatement();
		//ResultSet rs1=stmt.executeQuery("delete from CLIENT1_XBBNHC2 where Client_Name='+Priya';");
		ResultSet rs = stmt.executeQuery("select * from CLIENT_XBBX2 order by CLIENT_ID");
		
		while(rs.next()) {
			System.out.println(rs.getInt("CLIENT_ID")+"   "+rs.getString("CLIENT_NAME")+"   "+rs.getString("C_DATE")+"   "+rs.getString("C_PASSWORD")+"   "+rs.getString("CLIENT_ADDRESS")+"   "+rs.getString("DELIVERY_ADDRESS"));
			client = new Clients();
			client.setid(rs.getInt("CLIENT_ID"));
			client.setname(rs.getString("CLIENT_NAME"));
			client.setdate(rs.getString("C_DATE"));
			client.setpassword(rs.getString("C_PASSWORD"));
			client.setaddress(rs.getString("CLIENT_ADDRESS"));
			client.setaddress2(rs.getString("DELIVERY_ADDRESS"));
			ClientList.add(client);
		}
	
	 }
	catch(Exception e){
		
		
	}
	finally{
		try{		con.close();}
		catch(Exception e)
		{
			
		}
	}
	return ClientList;		
}


public boolean authenticateUser(Clients user) {
	// TODO Auto-generated method stub
	Connection con=null;
	String password=null;
	boolean aunthentaction=false;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}catch(ClassNotFoundException e) {
		System.out.println(e);
	}
	
	try{
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
		Statement s=con.createStatement();
		
		String sql="select C_PASSWORD from CLIENT_XBBX2 where Client_Name='"+user.getname()+"'";
		System.out.println(sql);
		ResultSet rs=s.executeQuery(sql);
		
		while(rs.next()){
			
			password=rs.getString("Password");
		}
		
	}catch(Exception e){
		
		System.out.println("exception occured"+e);
	}
	
	
	if(user.getpassword().equals(password)){
		aunthentaction=true;
		
	}
	return aunthentaction;
	
	
	
	
	
	
}
}
















