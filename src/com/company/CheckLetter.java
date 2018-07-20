package com.company;

class CheckLetter implements Constants {
   public static int result(int letNum){
       if (letNum >= START_CAPITAL & letNum <= END_CAPITEL) {
           return CAPITAL_LETTER;
       }
       else if (letNum >= START_LOWER &  letNum <= END_LOWER) {
       return LOW_LETTER;
       }
       else
           return NOT_LETTER;
    }

 }
