package com.dsa.codeforces;

public class BinaryExponentiation {


    public static int binaryExponentiation(int a, int n){
        if(n == 0){
            return 1;
        }
        if(n % 2 == 0){
            return binaryExponentiation(a*a, n/2);
        }else{
            return a*binaryExponentiation(a*a, n/2);
        }
    }

    public static int binaryExponentiationIter(int a, int n){
        int res = 1;
        while (n > 0){
            if(n % 2 == 1){
                res *= a;
            }
            a = a*a;
            n = n / 2;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(binaryExponentiation(2, 11));
    }
}
