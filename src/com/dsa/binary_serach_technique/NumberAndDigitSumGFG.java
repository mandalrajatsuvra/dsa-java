package com.dsa.binary_serach_technique;

public class NumberAndDigitSumGFG {
    /*
    *  990
    *  0 SUM =0, N = 99;
    *  9 SUM = 9 N = 9;
    *
    *  n = 13
    * l =1 r = 13 m = 7
    *  l = 8, r = 13 m  10
    *  l = 8 r = 10   m = 9
    * l = 10 r = 10
    *
    * */
    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit;
            n = n / 10;
        }
        return sum;
    }
    public int numberCount(int n, int k) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int value = mid - sumOfDigits(mid);
            if (value >= k) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return n-left+1;

    }


    public static void main(String[] args) {

    }
}
