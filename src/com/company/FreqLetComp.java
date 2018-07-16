package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;


public  class FreqLetComp implements constants {

    private double freqLet [] = new double[26];
    private BufferedReader txtBuf;
    private byte byteBuf [];
    private  int countLetter = 0;

    public FreqLetComp(BufferedReader buf){
        this.txtBuf = buf;
        handler();
    }

    public FreqLetComp(byte[] buf){
        byteBuf = buf;
        handlerByte();
    }

    private void handlerByte() {
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

    public double [] getFreqLett(){
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


