package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetSum {

    public static void solve(int i, int s, int [] arr, ArrayList<Integer > res){
        if(i == arr.length){
            res.add(s);
            return;
        }
        solve(i+1,s + arr[i],arr,res);
        solve(i+1,s,arr,res);
    }


    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> res = new ArrayList<>();
        solve(0,0,num,res);
        Collections.sort(res);
        return res;
    }


    public static void main(String[] args) {
        int []num = {1, 2};
        ArrayList<Integer> res = subsetSum(num);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
