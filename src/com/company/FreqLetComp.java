package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
interface constants{
    int StartCapital = 65;
    int EndCapitel = 90;
    int StartLower = 97;
    int EndLower = 122;
}

public class FreqLetComp implements constants {

    private int freqLetArr [] = new int [26];
    private BufferedReader txtBuf;

    public FreqLetComp(BufferedReader buf){
        this.txtBuf = buf;
    }
    void handler (){
        try {
            int num ;
            while((num = txtBuf.read())!= -1) {
                if (num >= StartCapital & num < EndCapitel) {
                    ++freqLetArr[num - StartCapital];
                }
                else if (num >= StartLower &  num < EndLower) {
                    ++freqLetArr[num - StartLower];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public int [] getFreqLett(){
        return  freqLetArr;
    }
    @Override
    public String toString()
    {
        String res = null;
        for (int i=0; i<freqLetArr.length; ++i) {
            res += ((char)(i + StartCapital) + " " + freqLetArr[i] +"\n" );
        }
        return res ;
    }


}
