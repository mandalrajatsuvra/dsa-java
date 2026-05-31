package com.dsa.recursion.permutations;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public void solve(int open, int close, int n, String pr, List<String> res){

        if(open > n || close > n) return;

        if(open == n && close == n){
            res.add(new String(pr));
            return;
        }
        if(open > close){
            solve(open+1, close, n, pr+ "(", res);
            solve(open, close+1, n, pr+")", res);
        }else{
            solve(open+1, close, n, pr+"(", res);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        solve(0, 0, n, "", res);
        return res;
    }
}
public class GenerateParenthesis {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.generateParenthesis(3);
        System.out.println(res);
    }
}
