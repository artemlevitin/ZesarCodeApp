package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        //  CodingText.codding("Text.txt",3);

        String filePath = "Text_Code.txt";
        byte[] buf;

        buf = readWriteFile(filePath);



        //CodingText.encodding(ReadFile(filePath),);
        System.out.println(new Comparer(new FreqLetComp(buf).getFreqLett()).getPrecission());


        System.out.println(new Comparer(fileFreqLet(filePath)).getPrecission());

        //  CodingText.encodding("Text_Code.txt",3);

    }

    private static byte[] readWriteFile(String filePath) {
        try {
            return Files.readAllBytes(Paths.get(filePath));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
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
            FreqLetComp freqLetComp = new FreqLetComp(bufRd);

                     return freqLetComp.getFreqLett();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

  /*  private static double[] freqCompByte(String filePath) {
        try(BufferedReader bufRd = new BufferedReader(new FileReader(filePath))){
            FreqLetComp freqLetComp = new FreqLetComp(bufRd);
            return freqLetComp.getFreqLett();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }*/

}
