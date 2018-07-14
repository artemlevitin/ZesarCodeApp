package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader bufRd = new BufferedReader(new FileReader("Text.txt"))){

            FreqLetComp freqLetComp = new FreqLetComp(bufRd);
            freqLetComp.handler();
            System.out.println(freqLetComp);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
