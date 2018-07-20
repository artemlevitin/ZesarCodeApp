package com.company;

public class Comparer implements Constants {

    static public double getPrecission(double freqLet[]) {
        double precission = 0;
        for (int i = 0; FREQ_LET_ETALON.length > i; ++i) {
            precission += Math.abs(FREQ_LET_ETALON[i]-freqLet[i]);
        }
        return precission;
    }
}
