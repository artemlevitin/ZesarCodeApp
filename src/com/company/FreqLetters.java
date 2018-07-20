package com.company;

import java.io.BufferedReader;
import java.io.IOException;


public  class FreqLetters implements Constants {

    private double freqLet [] = new double[26];
    private BufferedReader txtBuf;
    private byte inputBytes [];
    private  int countLetter = 0;

    public FreqLetters(BufferedReader buf){
        this.txtBuf = buf;
        handler_Bufferreader();
    }

    public FreqLetters(byte[] buf){
        inputBytes = buf;
        handlerByte();
    }

    private void handlerByte() {
        int num;

        for (num =0; inputBytes.length > num; ++num) {
                switch (CheckLetter.result(inputBytes[num])) {
                    case NOT_LETTER:
                        break;

                    case CAPITAL_LETTER:
                        ++freqLet[inputBytes[num]- START_CAPITAL];
                        ++countLetter;
                        break;

                    case LOW_LETTER:
                        ++freqLet[inputBytes[num]- START_LOWER];
                        ++countLetter;
                        break;

                    default:
                        break;
                }

        }
        //Recalculate to relative value
        for (int i = 0; freqLet.length > i; ++i) {
            freqLet[i] = 100 * freqLet[i] / countLetter;
        }
    }

    private void handler_Bufferreader(){
        try {
            int num ;
            while((num = txtBuf.read())!= -1) {
                switch (CheckLetter.result(num)) {
                    case NOT_LETTER:
                        break;

                    case CAPITAL_LETTER:
                        ++freqLet[num - START_CAPITAL];
                        ++countLetter;
                        break;

                    case LOW_LETTER:
                        ++freqLet[num - START_LOWER];
                        ++countLetter;
                        break;

                    default:
                        break;
                }

            }
            //Recalculate to relative value
            for(int i=0;freqLet.length > i; ++i){
                freqLet[i]= 100*freqLet[i]/countLetter;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public double [] get(){
        return  freqLet;
    }

    @Override
    public String toString()
    {
        String res = "";
        for (int i=0; i < freqLet.length; ++i) {
            res += ((char)(i + START_CAPITAL) + " " + freqLet[i] +"\n" );
        }
        return res ;
    }


}


