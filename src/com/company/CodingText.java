package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public  class CodingText {
    //  static public execute(String fileputh, int key){

    static public void codding(String filePath, int key) {
        try {
            byte[] buf = Files.readAllBytes(Paths.get(filePath));
            for (int i = 0; i < buf.length; ++i) {
                buf[i] += key;
            }

            int p = filePath.lastIndexOf(".");
            String newFilePath = filePath.substring(0, p) + "_Code" + filePath.substring(p);
            Files.write(Paths.get(newFilePath), buf);
        } catch (Exception exc) {
            System.out.print(exc.toString());
        }


    }

    static public void encodding(String filePath, int key) {
        try {
            byte[] buf = Files.readAllBytes(Paths.get(filePath));
            for (int i = 0; i < buf.length; ++i) {
                buf[i] -= key;
            }

            int p = filePath.lastIndexOf(".");
            String newFilePath = filePath.substring(0, p) + "_Code" + filePath.substring(p);
            Files.write(Paths.get(newFilePath), buf);
        } catch (Exception exc) {
            System.out.print(exc.toString());
        }
    }
}
