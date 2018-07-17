package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
       //  CodingText.codding("Text.txt",3);

        String filePath = "Text_Code.txt";

        System.out.println(new Comparer( fileFreqLet(filePath) ).getPrecission());


        System.out.println(new Comparer( fileFreqLet(filePath) ).getPrecission());

      //  CodingText.encodding("Text_Code.txt",3);

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
    private static double[] freqCompByte(String filePath) {
        try(BufferedReader bufRd = new BufferedReader(new FileReader(filePath))){
            FreqLetComp freqLetComp = new FreqLetComp(bufRd);
            return freqLetComp.getFreqLett();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
