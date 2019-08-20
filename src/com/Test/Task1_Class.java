package com.Test;

import java.sql.*;

public class Task1_Class{


    public void connctdata(){
        Task2_Class t2 = new Task2_Class();
        t2.getPropValues();
        try{
//step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object
            Connection con=DriverManager.getConnection(t2.db_url,t2.db_user,t2.db_password);
            if(con!=null){
                System.out.println("Database loaded");
            }
            else{
                System.out.println("Database failed");
            }

            Statement stmt=con.createStatement();
           // ResultSet resultSet = stmt.executeQuery()
            con.close();

        }catch(Exception e){ System.out.println(e);}

    }
}