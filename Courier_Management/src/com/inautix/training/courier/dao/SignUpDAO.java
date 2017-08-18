package com.inautix.training.courier.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.inautix.training.courier.domain.Clients;
import com.inautix.training.courier.domain.Employees;
import com.inautix.training.courier.domain.Employees;

public class SignUpDAO {
	public void createUser(Employees user){
		System.out.println("inside createUser method");
		Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		
		try{
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			Statement s=con.createStatement();
			String sql = "insert into EMPLOYEESXXS_XBBNHC2 values('"+ user.getname()+"','"+user.getpswrd()+"')";
			System.out.println(sql);
			s.execute(sql);
			con.commit();
			System.out.println("Record inserted");
			
			
		}catch(Exception e){
			
			System.out.println("exception occured 2 "+e);
		}
		
		
	}
	
    public boolean authenticateLogIn(Employees user){
        
        Connection con=null;
        String password1=null;
        boolean aunthentaction=false;
        
        try {
               Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(ClassNotFoundException e) {
               System.out.println(e);
        }
        
        try{
               
        	con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			Statement s=con.createStatement();
			String sql="select Emp_Password from EMPLOYEESIGNUP where Emp_Name='"+user.getname()+"'";
			System.out.println(sql);
			s.execute(sql);
			con.commit();
			System.out.println("table inserted");
               
               
               System.out.println(sql);
               ResultSet rs=s.executeQuery(sql);
               
               while(rs.next()){
                     
                     password1=rs.getString("Emp_Password");
               }
               
        }catch(Exception e){
               
               System.out.println("exception occured 2 "+e);
        }
        
        
        if(user.getpswrd().equals(password1)){
               aunthentaction=true;
               
        }
        return aunthentaction;
        
 }
 

}
