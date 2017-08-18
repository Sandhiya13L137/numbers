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
import com.inautix.training.courier.domain.Owner;
public class ClientDAO3 {
	public static void createEmployee(Employees clients)
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
		
		String sql ="insert into EMPLOYEEXS_XBBNHC2 values('"+ clients.getname()+"','"+clients.getpswrd()+"')";

				
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

	public static void createEmployee1(Employees clients)
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
		
		String sql ="insert into EMPLOYEES_XXBX values('"+ clients.getname()+"','"+clients.getdate()+"',"+clients.getid()+",'"+clients.getamount()+"','"+clients.getstatus()+"')";

				
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
	public boolean authenticateClient(Clients user) {
		// TODO Auto-generated method stub
		Connection con=null;
		String loginid=null;
		boolean aunthentaction=false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		
		try{
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			Statement s=con.createStatement();
			
			String sql="select C_PASSWORD from CLIENT_XBBX2 where CLIENT_NAME='"+user.getname()+"'";
			System.out.println(sql);
			ResultSet rs=s.executeQuery(sql);
			
			while(rs.next()){
				
				loginid=rs.getString("C_Password");
			}
			
		}catch(Exception e){
			
			System.out.println("exception occured"+e);
		}
		
		
		if(user.getpassword().equals(loginid)){
			aunthentaction=true;
			
		}
		return aunthentaction;
		
		
		
	}
	public Employees getEmployeeDetails1(int id)

	{
		Connection con=null;
		 
		 Employees client = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
		System.out.println(e);
		}

		try {
		con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");

		Statement stmt = con.createStatement();
		String sql = "select * from EMPLOYEES_XXBX where COURIER_ID="+id;
		System.out.println("SQL "+sql);
		ResultSet rs = stmt.executeQuery(sql);
				

		client=new Employees();
		while(rs.next()){
		System.out.println(rs.getString("Employee_Name")+"   "+rs.getString("E_Date")+"   "+rs.getInt("Courier_ID")+"   "
	        +rs.getString("Amount")+" "+rs.getString("Status"));
		client.setname(rs.getString("Employee_Name"));
		client.setdate(rs.getString("E_Date"));
		client.setid(rs.getInt("Courier_ID"));
		client.setamount(rs.getString("Amount"));
		client.setstatus(rs.getString("Status"));
		}}
		catch(Exception e){


		}finally{
		try{
			
			con.close();
		}catch(Exception e){
			
		}
		}

		return client;
		}

public List getAllEmployees(){
	Connection con=null;
	List EmployeeList = new ArrayList();
	Employees client = null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}catch(ClassNotFoundException e) {
		System.out.println(e);
	}

	try {
		con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");

		Statement stmt = con.createStatement();
		//ResultSet rs1=stmt.executeQuery("delete from CLIENT1_XBBNHC2 where Client_Name='+Priya';");
		ResultSet rs = stmt.executeQuery("select * from EMPLOYEES_XXBX order by COURIER_ID");
		
		while(rs.next()) {
			client=new Employees();
			System.out.println(rs.getString("Employee_Name")+"   "+rs.getString("E_Date")+"   "+rs.getInt("Courier_ID")+"   "
		        +rs.getInt("Amount")+" "+rs.getString("Status"));
			client.setname(rs.getString("Employee_Name"));
			client.setdate(rs.getString("E_Date"));
			client.setid(rs.getInt("Courier_ID"));
			client.setamount(rs.getString("Amount"));
			client.setstatus(rs.getString("Status"));
			EmployeeList.add(client);
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
	return EmployeeList;		
}

public boolean authenticateUser(Employees user) {
	// TODO Auto-generated method stub
	Connection con=null;
	String id=null;
	boolean aunthentaction=false;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}catch(ClassNotFoundException e) {
		System.out.println(e);
	}
	
	try{
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
		Statement s=con.createStatement();
		
		String sql="select Login_ID from EMPLOYEEXS_XBBNHC2 where Employee_Name='"+user.getname()+"'";
		System.out.println(sql);
		ResultSet rs=s.executeQuery(sql);
		
		while(rs.next()){
			
			id=rs.getString("Login_ID");
		}
		
	}catch(Exception e){
		
		System.out.println("exception occured"+e);
	}
	
	System.out.println("Id "+id);
	if(user.getpswrd().equals(id)){
		aunthentaction=true;
		
	}
	return aunthentaction;
	
	
	
	
}

public static void createOwner(Owner clients)
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
	
	String sql ="insert into OWNERX_XBBNHC2 values('"+ clients.getname()+"','"+clients.getid()+"')";

			
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
	
	String sql ="insert into CLIENTLOGIN values ("+"'"+clients.getname()+"'"+",'"+clients.getpassword()+"')";
			
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
		ResultSet rs = stmt.executeQuery("select * from CLIENT_XBBX2");
		
		while(rs.next()) {
			System.out.println(rs.getInt("CLIENT_ID")+"   "+rs.getString("CLIENT_NAME")+"   "+rs.getString("C_DATE")+"   "+rs.getInt("C_PASSWORD")+"   "+rs.getString("CLIENT_ADDRESS")+"   "+rs.getString("DELIVERY_ADDRESS"));
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
public boolean authenticateOwner(Owner user) {
	// TODO Auto-generated method stub
	Connection con=null;
	String loginid=null;
	boolean aunthentaction=false;
	
	try 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	catch(ClassNotFoundException e) 
	{
		System.out.println(e);
	}
	
	try
	{
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
		Statement s=con.createStatement();
		
		String sql="select Owner_Id from OWNERX_XBBNHC2 where Owner_Name='"+user.getname()+"'";
		System.out.println(sql);
		ResultSet rs=s.executeQuery(sql);
		
		while(rs.next()){
			
			loginid=rs.getString("Owner_Id");
		}
		
	}
	catch(Exception e)
	{
		
		System.out.println("exception occured"+e);
	}
	
	
	if(user.getid().equals(loginid))
	{
		aunthentaction=true;
		
	}
	return aunthentaction;
		
}
		
}

















