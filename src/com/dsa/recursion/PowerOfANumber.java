package com.dsa.recursion;

public class PowerOfANumber {
    public static long power(int N,int R)
    {
        if(R == 0) return 1;
        if(R == 1) return N;
        if(R % 2 == 0){
            return power(N * N, R/2);
        }else{
            return  N* power(N, R-1);
        }
    }
    public static void main(String[] args) {

    }
}
