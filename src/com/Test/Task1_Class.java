package com.Test;

import java.sql.*;

public class Task1_Class{

    public void connctdata(){
        try{
//step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:2521:orcl","ppb","ppb");
            if(con!=null){
                System.out.println("Database loaded");
            }
            else{
                System.out.println("Database failed");
            }
            con.close();

        }catch(Exception e){ System.out.println(e);}

    }
}