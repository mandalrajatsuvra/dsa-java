package com.dsa.recursion.backtracking;

import java.util.Arrays;

public class WildcardMatching {

    public boolean solve(String txt, int i, String pat, int j, int [][]dp){
        if(i == 0 && j== 0){
            return true;
        }else if(j ==0){
            return false;
        }else if(i==0){
            while (j > 0){
                if(pat.charAt(j-1) != '*'){
                    return false;
                }
                j--;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 1;
        if(pat.charAt(j-1) == '*'){
            dp[i][j] =  solve(txt, i-1, pat, j, dp) || solve(txt, i, pat, j-1, dp) ? 1: 0;
            return dp[i][j] == 1;
        }else if(pat.charAt(j-1) == '?'){
             dp[i][j]  = solve(txt, i-1, pat, j-1, dp)? 1: 0;
             return dp[i][j] == 1;
        }else if(txt.charAt(i-1) == pat.charAt(j-1)){
            dp[i][j]  = solve(txt, i-1, pat, j-1, dp)? 1: 0;
            return dp[i][j] == 1;
        }else{
            return false;
        }
    }
    public boolean wildCard(String txt, String pat) {
        int [][] dp = new int[txt.length()+1][pat.length()+1];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        return solve(txt, txt.length(), pat, pat.length(), dp);
    }

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.wildCard("abcde", "**a?c*"));
    }
}
