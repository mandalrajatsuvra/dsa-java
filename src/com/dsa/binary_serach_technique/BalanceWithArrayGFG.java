package com.dsa.binary_serach_technique;

import java.util.Arrays;

public class BalanceWithArrayGFG {

    public boolean isBalanced(int[] arr, int x) {
        Arrays.sort(arr);
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int lowerBound = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] <= x){
                lowerBound = arr[mid];
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        left = 0;
        right = n - 1;
        int upperBound = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] >= x){
                upperBound = arr[mid];
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if(lowerBound == -1 || upperBound == -1){
            return true;
        }
        return Math.abs(lowerBound-x) == Math.abs(upperBound-x);
    }


    public static void main(String[] args) {

    }
}
