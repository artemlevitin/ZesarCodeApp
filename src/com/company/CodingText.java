package com.company;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;



public  class CodingText implements Constants {
    //  static public execute(String fileputh, int key){
    //private byte bufTxt[];


    static public void codding(String filePath, int key) {
        try {
            byte[] buf = Files.readAllBytes(Paths.get(filePath));
            for (int i = 0; i < buf.length; ++i) {
               if(CheckLetter.result(buf[i])!= NOT_LETTER)
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
                if (CheckLetter.result( buf[i]-key)!= NOT_LETTER)
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

    static public ByteArrayInputStream  encodding(ByteArrayInputStream bais, int key) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b;
            while ((  b = bais.read())!= -1)
            {
                b -= key;
                baos.write(b);
          }
           byte [] byteAr = baos.toByteArray();

          return new ByteArrayInputStream(byteAr);

        } catch (Exception exc) {
            System.out.print(exc.toString());
            return null;
        }
    }

    static public byte[]  encodding(byte [] inpByte , int key) {
        try {
           byte [] outBytes = new byte[inpByte.length];
           System.arraycopy(inpByte,0,outBytes,0,inpByte.length);

            for(int i=0; i<outBytes.length; ++i) {
                outBytes[i] -= key;
             }

            return outBytes;

        } catch (Exception exc) {
            System.out.print(exc.toString());
            return null;
        }
    }
}
