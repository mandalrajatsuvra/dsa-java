package com.dsa.codeforces;

import java.math.BigInteger;
import java.util.Scanner;

public class CanISquare {

    public static boolean canISquare(long x) {
        long start = 1;
        long end = x;
        while(start <= end){
            long mid = start + (end - start)/2;

            BigInteger midIn = new BigInteger(Long.toString(mid));
            BigInteger square = midIn.multiply(midIn);

            if(square.compareTo(BigInteger.valueOf(x))==0){
                return true;
            }else if(square.compareTo(BigInteger.valueOf(x)) < 0){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        for(int i = 0; i < noOfTestCases; i++){
            int n = sc.nextInt();
            long sum =0l;
            for(int j = 0; j < n; j++){
                sum += sc.nextLong();
            }
            if(canISquare(sum)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
