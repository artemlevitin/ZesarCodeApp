package com.company;

public class Comparer {
    private double freqLetEtalon[]; 
    private double precission;

    public Comparer(double freqLet[]) {
        initialazer();
        execute(freqLet);
    }

    private void execute(double[] freqLet) {
        for (int i = 0; freqLetEtalon.length > i; ++i) {
           precission += Math.abs(freqLetEtalon[i]-freqLet[i]);
        }
    }

    private void initialazer(){
        freqLetEtalon = new double[]{8.1,1.4,2.7,3.9,13,2.9,2,5.2,6.5,0.2,0.4,3.4,2.5,7.2,7.9,2,6.9,6.1,10.5,2.4,0.9,1.5,0.2,1.9,0.1 };
        precission = 0;
    }

    public double getPrecission() {
        return precission;
    }
}
