package com.dsa.recursion.backtracking;

public class FairDistributionOfCookies {

    public static void solve(int [] cookies, int index, int k, int [] distribute, int [] maxFairness){
        if(index == cookies.length){
            int maxValue = Integer.MIN_VALUE;
            for(int i=0; i< k; i++){
                maxValue = Math.max(maxValue, distribute[i]);
            }
            maxFairness[0] = Math.min(maxFairness[0], maxValue);
            return;
        }
        for(int i=0; i< k; i++){
            distribute[i] += cookies[index];
            solve(cookies, index+1, k, distribute, maxFairness);
            distribute[i] -= cookies[index];
        }
    }


    public static int distributeCookies(int[] cookies, int k) {
        int [] distribute = new int[k];
        int [] maxFairness = new int[]{Integer.MAX_VALUE};
        solve(cookies, 0, k, distribute, maxFairness);
        return maxFairness[0];
    }

    public static void main(String[] args) {
        int [] cookies = {8,15,10,20,8};
        System.out.println(distributeCookies(cookies, 2));
    }
}
