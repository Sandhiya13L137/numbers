package com.inautix.training.courier.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.inautix.training.courier.domain.StatusUpdate;

public class UpdateStatus {
	
        public void updatestatus(StatusUpdate su){
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
                                        String sql ="update EMPLOYEES_XXBX set STATUS ='"+su.getstatus()+"' where COURIER_ID="+su.getid()+" ";

                                        System.out.println(sql);
                                        s.execute(sql);
                                        con.commit();
                                        
                                        System.out.println("record inserted");
                                        
                                        con.close();
                        }
                        catch(Exception e){
                                        
                                        System.out.println("exception occured 2 "+e);
                        }
        }
}


