package com.dsa.recursion;

public class RecursionBasic {
//              ind
    // 2, 3, 4, 5

    public static int sum(int []arr, int len){
        if(len == 0) return 0;
        int partialSum = sum(arr, len -1);
        return partialSum + arr[len-1];
    }
    public static int sumOfNumbersInArray(int [] arr){
        return sum(arr, arr.length);
    }
    public static void main(String[] args) {
        int [] arr = {1, 2,3 ,4, 5};
        System.out.println(sumOfNumbersInArray(arr));
    }
}
