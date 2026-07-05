package com.dsa.binary_serach_technique;

import java.util.Arrays;

public class LongestIncreasingSubsequenceGFG {


    public static int f(int index, int selected,int[] arr, int[][] dp) {
        if (index == arr.length) {
            return 0;
        }

        if (dp[index][selected+1] != -1) {
            return dp[index][selected+1];
        }

        if(selected == -1 || arr[index] > arr[selected] ) {
            return dp[index][selected+1] =  Math.max(
             1 + f(index+1, index, arr, dp),
                f(index+1, selected, arr, dp)
            );
        }else{
            return dp[index][selected+1] = f(index+1, selected, arr, dp);
        }

    }

    public static int lis(int arr[]) {

        int [][] dp = new int[arr.length][arr.length+1];
        for(int [] a: dp){
            Arrays.fill(a,-1);
        }
        return f(0, -1, arr, dp);
    }
    public static void main(String[] args) {
        int []arr = {3, 10, 2, 1, 20};
        System.out.println(lis(arr));
    }
}
