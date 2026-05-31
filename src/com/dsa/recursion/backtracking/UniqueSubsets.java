package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class UniqueSubsets {


    public static void solve(int i, int []arr, ArrayList<Integer> pr, HashSet<ArrayList<Integer>> res){
        if(i==arr.length){
            res.add(new ArrayList<>(pr));
            return;
        }
        solve(i+1, arr, pr, res);
        pr.add(arr[i]);
        solve(i+1, arr, pr, res);
        pr.remove(pr.size()-1);
    }

    public static ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int n) {
        Arrays.sort(arr);
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        solve(0, arr, new ArrayList<>(), res);
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>(res);
        Collections.sort(resList, (a, b)->{
            int i=0, j=0;
            while(i < a.size() && j < b.size()){
                if(a.get(i) == b.get(j)){
                    i++;
                    j++;
                }else if(a.get(i) > b.get(j)){
                    return 1;
                }else {
                    return -1;
                }
            }
            if(i==a.size()){
                return -1;
            }else{
                return 1;
            }

        });
        return resList;
    }
    public static void main(String[] args) {
        int [] arr = {1, 2, 2};
        ArrayList<ArrayList<Integer>> res = AllSubsets(arr, arr.length);
        System.out.println(res);
    }
}
