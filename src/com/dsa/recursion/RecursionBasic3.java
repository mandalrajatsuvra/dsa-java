package com.dsa.recursion;

public class RecursionBasic3 {

    public static int [] maxAndMin(int []arr, int len){
        if(len == 0) return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        int [] partialMinMax = maxAndMin(arr, len -1);
        int currentMax = Math.max(arr[len-1], partialMinMax[0]);
        int currentMin = Math.min(arr[len-1], partialMinMax[1]);
        return new int[]{currentMax, currentMin};
    }

    public static void main(String[] args) {
        int [] arr = {-90, 100, 200, 88, 900, 777};
        int [] minAndMax =maxAndMin(arr, arr.length);
        System.out.println("Min -> " + minAndMax[1]);
        System.out.println("Max -> " + minAndMax[0]);

    }
}
