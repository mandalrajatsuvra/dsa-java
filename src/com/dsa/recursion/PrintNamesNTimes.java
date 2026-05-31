package com.dsa.recursion;

public class PrintNamesNTimes {

    public static void printNameNTimes(int i, int n){
        if(i > n) return;
        System.out.println("Rajat");
        printNameNTimes(i+1, n);
    }
    public static void main(String[] args) {
        printNameNTimes(1, 3);
    }
}
