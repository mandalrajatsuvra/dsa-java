package com.dsa.recursion;

public class RecursionBasic2 {
    public static int f(int [] arr, int len){
        if(len == 0) return Integer.MIN_VALUE;
        int partialMaximum = f(arr, len-1);
        //System.out.println(partialMaximum +"  "+ (len -1));
        return Math.max(partialMaximum, arr[len-1]);
    }
    public static int maximumNumbers(int [] arr){
        return f(arr, arr.length);
    }
    public static void main(String[] args) {
        System.out.println(maximumNumbers(new int[]{-1, 1, 10, -90}));
    }
}
