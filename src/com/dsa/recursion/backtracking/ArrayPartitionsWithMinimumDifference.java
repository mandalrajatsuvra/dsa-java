package com.dsa.recursion.backtracking;

import java.util.Arrays;

public class ArrayPartitionsWithMinimumDifference {

    public static int solve(int i, int totalSum, int [] arr, int n, int [][] dp){
        if(i==n){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int take = Math.abs(arr[i] + solve(i+1, totalSum, arr, n, dp ) - solve(i+1, totalSum, arr, n, dp ));
        int notTake = Math.abs(solve(i+1, totalSum, arr, n, dp ) - arr[i] - solve(i+1, totalSum, arr, n, dp ));
        return Math.min(min,take-notTake);
    }
    public static int minSubsetSumDifference(int []arr, int n) {
        int sum = Arrays.stream(arr).sum();
        int [][] dp = new int[n+1][sum+1];
        return solve(0, sum, arr, n, dp);
    }
    public static void main(String[] args) {
        int [] arr = {1,2, 3, 4, 5};
        int n = arr.length;
        System.out.println(minSubsetSumDifference(arr, n));
    }
}
