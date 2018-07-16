package com.company;

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
