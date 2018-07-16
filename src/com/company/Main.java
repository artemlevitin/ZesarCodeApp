package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
        String filePath = "Text.txt";
        System.out.println(new Comparer( freqComp(filePath) ).getPrecission());

         filePath = "Text_Code.txt";
        System.out.println(new Comparer( freqComp(filePath) ).getPrecission());
        //FreqCheck();

        //CodingText.codding("Text.txt",3);
    }

    private static double[] freqComp(String filePath) {
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
