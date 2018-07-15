package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
interface constants{
    int StartCapital = 65;
    int EndCapitel = 90;
    int StartLower = 97;
    int EndLower = 122;
    
    int CapitalLetter = 1;
    int LowLetter = 2 ;
    int NotLetter =0;
}

class CheckLetter implements constants{
   public static int result(int letNum){
       if (letNum >= StartCapital & letNum <= EndCapitel) {
           return CapitalLetter;
       }
       else if (letNum >= StartLower &  letNum <= EndLower) {
       return LowLetter;
       }
       else
           return NotLetter;
    }

 }

public  class FreqLetComp implements constants {

    private int freqLet [] = new int [26];
    private BufferedReader txtBuf;
    private  int countLetter = 0;

    public FreqLetComp(BufferedReader buf){
        this.txtBuf = buf;
        handler();
    }
    private void handler (){
        try {
            int num ;
            while((num = txtBuf.read())!= -1) {
                switch (CheckLetter.result(num)) {
                    case NotLetter:
                        break;

                    case CapitalLetter:
                        ++freqLet[num - StartCapital];
                        ++countLetter;
                        break;

                    case LowLetter:
                        ++freqLet[num - StartLower];
                        ++countLetter;
                        break;

                    default:
                        break;
                }

            }

            for(int i=0;freqLet.length > i; ++i){
                freqLet[i]= 100*freqLet[i]/countLetter;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int [] getFreqLett(){
        return  freqLet;
    }

    @Override
    public String toString()
    {
        String res = "";
        for (int i=0; i < freqLet.length; ++i) {
            res += ((char)(i + StartCapital) + " " + freqLet[i] +"\n" );
        }
        return res ;
    }


}


