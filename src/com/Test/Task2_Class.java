package com.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Task2_Class{
    String result="";
    InputStream inputStream;
    String db_url;
    String db_user;
    String db_password;
    String root_path;
    String threads_num;
    public void getPropValues(){
        try{
            Properties properties = new Properties();
            String propFilename="com\\config\\config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFilename);

            if(inputStream!=null)
            {
                properties.load(inputStream);
            }
            else
            {
                throw new FileNotFoundException("Config file: "+propFilename + " not found");
            }

            db_url = properties.getProperty("db_url");
            db_user = properties.getProperty("db_user");
            db_password = properties.getProperty("db_password");
            root_path = properties.getProperty("root_path");
            threads_num = properties.getProperty("threads_num");
            inputStream.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

    }

}
