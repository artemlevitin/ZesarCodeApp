package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
        FreqCheck();
        //CodingText.codding("Text.txt",3);
    }

    private static void FreqCheck() {
        try(BufferedReader bufRd = new BufferedReader(new FileReader("Text.txt"))){

            FreqLetComp freqLetComp = new FreqLetComp(bufRd);
             System.out.println(freqLetComp);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }


}
