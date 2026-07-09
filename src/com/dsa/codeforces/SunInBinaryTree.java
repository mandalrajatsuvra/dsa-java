package com.dsa.codeforces;

import java.math.BigInteger;
import java.util.Scanner;

public class SunInBinaryTree {
    public static BigInteger calculateSum(long n){
        BigInteger sum = new BigInteger("0");
        while (n >= 1){
            sum = sum.add(BigInteger.valueOf(n));
            n = n/2;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i< n; i++){
            long num = sc.nextLong();
            BigInteger sum = calculateSum(num);
            System.out.println(sum);
        }
    }
}
