package com.company;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;



public  class CodingText implements constants {
    //  static public execute(String fileputh, int key){
    private byte bufTxt[];


    static public void codding(String filePath, int key) {
        try {
            byte[] buf = Files.readAllBytes(Paths.get(filePath));
            for (int i = 0; i < buf.length; ++i) {
               if(CheckLetter.result(buf[i])!=NotLetter)
                   buf[i] += key;
            }

            int p = filePath.lastIndexOf(".");
            String newFilePath = filePath.substring(0, p) + "_Code" + filePath.substring(p);
            Files.write(Paths.get(newFilePath), buf);
        } catch (Exception exc) {
            System.out.print(exc.toString());
        }


    }

    static public BufferedReader encodding(String filePath, int key) {
        try {
            byte[] buf = Files.readAllBytes(Paths.get(filePath));

            for (int i = 0; i < buf.length; ++i) {
                if (CheckLetter.result( buf[i]-key)!= NotLetter)
                buf[i] -= key;
            }

            return new BufferedReader( new InputStreamReader(new ByteArrayInputStream(buf)));

           /* int p = filePath.lastIndexOf(".");
            String newFilePath = filePath.substring(0, p) + "_Code" + filePath.substring(p);
            Files.write(Paths.get(newFilePath), buf);*/
        } catch (Exception exc) {
            System.out.print(exc.toString());
            return null;
        }
    }


}
