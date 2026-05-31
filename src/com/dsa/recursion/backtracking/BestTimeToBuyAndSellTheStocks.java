package com.dsa.recursion.backtracking;

import java.util.Arrays;

public class BestTimeToBuyAndSellTheStocks {


    public static int solve(int i, int buy, int [] prices, int k, int [][][] dp) {
        if(k < 0){
            return -1*(int)(1e9);
        }
        if(i== prices.length && buy == 1){
            return 0;
        }else if(i == prices.length){
            return -1*(int)(1e9);
        }

        if(dp[i][buy][k] != -1){
            return dp[i][buy][k];
        }

        if(buy == 1){
            return dp[i][buy][k] = Math.max(
                  -1* prices[i] + solve(i+1, 0, prices, k, dp),
                    solve(i+1, 1, prices, k, dp)
            );
        }else{
           return dp[i][buy][k] = Math.max(
                    prices[i] + solve(i+1, 1, prices, k-1, dp),
                    solve(i+1, 0, prices, k, dp)
            );
        }
    }

    public static int maxProfit(int[] prices) {
        int [][][] dp = new int[prices.length][2][3];
        for(int [][] e: dp){
            for(int [] a: e){
                Arrays.fill(a,-1);
            }
        }
        return solve(0, 1, prices, 2, dp);
    }
    public static void main(String[] args) {
        int [] prices = {1, 3, 1, 2, 4, 8};
        System.out.println(maxProfit(prices));
    }
}
