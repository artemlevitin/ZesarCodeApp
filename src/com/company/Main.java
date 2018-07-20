package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        //  CodingText.codding("Text.txt",3);

        String filePath = "Text_Code.txt";
        byte[] buf = readFile(filePath);
        byte[] buf2;
/*
        //CodingText.encodding(ReadFile(filePath),);
        //System.out.println( Comparer.getPrecission( new FreqLetters(buf).get() ) );
        double[] freqBuf1 = new FreqLetters(buf).get();
        double[] freqBuf2;
       // double[] freqBuf2 = new FreqLetters(buf2).get();
        for(int key=1; key < 12; ++key) {
            buf2 = CodingText.encodding(buf,key);
            freqBuf2 = new FreqLetters(buf2).get();
            if (Comparer.getPrecission(freqBuf1) > Comparer.getPrecission(freqBuf2)) {
                buf = buf2;
                freqBuf1 = freqBuf2;
            }
        }*/
        buf = CodingText.encodding(buf,3);

        writeFile(buf,filePath);
       // System.out.println( Comparer.getPrecission( new FreqLetters(buf2).get() ) );

       // System.out.println(Comparer.getPrecission((fileFreqLet(filePath))));

        //  CodingText.encodding("Text_Code.txt",3);

    }


    private static byte[] readFile(String filePath) {
        try {
            return Files.readAllBytes(Paths.get(filePath));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    private static void writeFile(byte[] txtBytes, String filePath) {
        try {
            int p = filePath.lastIndexOf(".");
            String newFilePath = filePath.substring(0, p) + "_Code" + filePath.substring(p);
            Files.write(Paths.get(newFilePath), txtBytes);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static BufferedReader ReadFile(String filePath) {
        try(BufferedReader bufRd = new BufferedReader(new FileReader(filePath))) {

            return bufRd;

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
           return null;
        }
    }

    private static double[] fileFreqLet(String filePath) {
        try(BufferedReader bufRd = new BufferedReader(new FileReader(filePath))){
            FreqLetters freqLetters = new FreqLetters(bufRd);

                     return freqLetters.get();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

  /*  private static double[] freqCompByte(String filePath) {
        try(BufferedReader bufRd = new BufferedReader(new FileReader(filePath))){
            FreqLetters freqLetComp = new FreqLetters(bufRd);
            return freqLetComp.get();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }*/

}

class Exch{

    public static byte[] readFile(String filePath) {
        try {
            return Files.readAllBytes(Paths.get(filePath));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }
    public static void writeFile(byte[] txtBytes,String filePath ) {
        try {
            int p = filePath.lastIndexOf(".");
            String newFilePath = filePath.substring(0, p) + "_Code" + filePath.substring(p);
            Files.write(Paths.get(newFilePath), txtBytes);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

    }
}