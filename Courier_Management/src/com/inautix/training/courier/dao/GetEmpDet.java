package com.inautix.training.courier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.inautix.training.courier.domain.Employees;
import com.inautix.training.courier.domain.StatusUpdate;

public class GetEmpDet {
	public Employees getempdet(int id){
        System.out.println("inside createUser method");
        Connection con=null;
        Employees emp=null;
        
        try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(ClassNotFoundException e) {
                        System.out.println(e);
        }
        
        try{
                        
                        con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
                        Statement s=con.createStatement();
                        String sql ="select * from EMPLOYEES_XXBX where COURIER_ID ="+id;

                        System.out.println(sql);
                        ResultSet rs=s.executeQuery(sql);
                        while(rs.next()) {
                            emp=new Employees();
                                System.out.println("inside while loop");
                                emp.setname(rs.getString("name"));
                                emp.setdate(rs.getString("date"));
                                emp.setamount(rs.getString("amount"));
                                emp.setstatus(rs.getString("status"));
                                
                                
                        }
        }
        catch(Exception e){
            
            
        }finally{
               try{
                      
                      con.close();
               }catch(Exception e){
                      
               }
        }


        return emp;
}
	 
}
