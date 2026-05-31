package com.dsa.recursion;

import java.util.ArrayList;

public class SubsetSum {
    public void solve(int indx, int []arr, int n, int  sum, ArrayList<Integer> res){
        if(indx == n) {
            res.add(sum);
            return;
        }
        solve(indx + 1, arr, n, sum + arr[indx],  res);
        solve(indx+ 1, arr, n, sum , res);
    }
    public  ArrayList<Integer>  subsetSums(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        solve(0, arr, arr.length, 0, res);
        return res;
    }
    public static void main(String[] args) {

    }
}
