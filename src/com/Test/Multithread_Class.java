package com.Test;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Multithread_Class{

    public static void main(String[] args){
        Task2_Class t2 = new Task2_Class();
        Logger_Class l = new Logger_Class();
        t2.getPropValues();
        System.out.println(t2.db_user);

         final String PATH =t2.root_path;
        WatchService watchService=null;
        Path dir = Paths.get(PATH);
        String FINAL_PATH=null;

        String fileName=null;
        String line;
        String split="\\|";

        List<String> result = new LinkedList<>();

        int header=0;

        boolean isFile = true;

        try(Stream<Path> paths = Files.walk(Paths.get(PATH))) {
            result = paths.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());
        }
        catch (Exception e) {
            System.out.println("No files there " + e);
        }


        for(int i=0;i<result.size();i++)
        {
            FINAL_PATH=result.get(i);
            System.out.println(FINAL_PATH);
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FINAL_PATH))) {

                while ((line = bufferedReader.readLine()) != null) {

                    if (header != 0 && !line.startsWith("Trailer")) {
                        String[] data = line.split(split);

                        System.out.println(data[0] + "|" + data[1] + "|" + data[2]+ "|" + data[3]+ "|" + data[4]+ "|" + data[5]+ "|" + data[6]+ "|" + data[7]+ "|" + data[8]+ "|" + data[9]+ "|" + data[10]
                                + "|" + data[11]+ "|" + data[12]+ "|" + data[13]+ "|" + data[14]+ "|" + data[15]+ "|" + data[16]+ "|" + data[17]+ "|" + data[18]+ "|" + data[19]+ "|" + data[20]+ "|" + data[21]
                                + "|" + data[22]+ "|" + data[23]+ "|" + data[24]+ "|" + data[25]+ "|" + data[26]+ "|" + data[27]+ "|" + data[28]+ "|" + data[29]+ "|" + data[30]+ "|" + data[31]+ "|" + data[32]
                                + "|" + data[35]);
                    } else if (header == 0) {
                        String[] head = line.split(split);
                        System.out.println(head[0] + "|" + head[1] + "|" + head[2]);
                    } else if (line.startsWith("Trailer")) {
                        String[] tail = line.split(split);
                        System.out.println(tail[0] + "|" + tail[1] + "|" + tail[2]);
                    }
                    header++;

                }
            } catch (IOException e) {
                System.out.println("IOException:" + e);
            }
        }
        l.log();
        Task1_Class t = new Task1_Class();
        t.connctdata();



         /*   try {
                watchService = FileSystems.getDefault().newWatchService();
                dir.register(watchService,StandardWatchEventKinds.ENTRY_CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }


        do{
            WatchKey watchKey = null;
            try {
                watchKey = watchService.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(WatchEvent event : watchKey.pollEvents()){
                WatchEvent.Kind kind = event.kind();
                 if(StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
                     {
                         fileName = event.context().toString();
                         System.out.println("File Created:" + fileName);
                         FINAL_PATH = PATH + fileName;
                         System.out.println(FINAL_PATH);
                     }
                 }
                 else {
                        while(!result.isEmpty())
                        {
                            FINAL_PATH=result.get(count);
                            System.out.println(FINAL_PATH);
                        }


                         try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FINAL_PATH))) {

                             while ((line = bufferedReader.readLine()) != null) {
                                 if (header != 0 && !line.startsWith("Trailer")) {
                                     String[] data = line.split(split);
                                     System.out.println(data[0] + "|" + data[1] + "|" + data[2]);
                                 } else if (header == 0) {
                                     String[] head = line.split(split);
                                     System.out.println(head[0] + "|" + head[1] + "|" + head[2]);
                                 } else if (line.startsWith("Trailer")) {
                                     String[] tail = line.split(split);
                                     System.out.println(tail[0] + "|" + tail[1] + "|" + tail[2]);
                                 }
                                 header++;
                                 count++;
                             }
                         } catch (IOException e) {
                             System.out.println("IOException:" + e);
                         }
                     }
                 }


            isFile=watchKey.reset();
        }while(isFile);
*/



    }
}
