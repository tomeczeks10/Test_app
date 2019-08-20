package com.Test;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

public class Logger_Class {
    protected static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Logger log()
    {
        File logfile = new File("C:\\Users\\tomasz.szerel\\IdeaProjects\\Test_app\\log.xml");
        if(logfile.delete()){
            System.out.println(logfile.getName() + " is deleted!");
        }else{
            System.out.println("Delete operation is failed.");
        }
        FileHandler fileHandler= null;
        try{
            fileHandler = new FileHandler("log.xml",true);
            logger.addHandler(fileHandler);
            logger.severe("severe message");

            logger.warning("warning message");

            logger.info("info message");

            logger.config("config message");

            logger.fine("fine message");

            logger.finer("finer message");

            logger.finest("finest message");
            fileHandler.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return logger;
    }
}
