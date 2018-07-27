package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        CodingText.codding("Text.txt",11);

        CodingText.encoddingFile("Text_Code.txt");






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

    private static double[] fileFreqLet(String filePath, int key) {
        try(BufferedReader bufRd = new BufferedReader(new FileReader(filePath))){
            FreqLetters freqLetters = new FreqLetters(bufRd, key);

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