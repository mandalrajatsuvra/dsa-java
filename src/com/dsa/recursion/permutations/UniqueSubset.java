package com.dsa.recursion.permutations;


import java.util.*;

public class UniqueSubset {

    public static void solve(int [] arr, int index, ArrayList<Integer> pr, TreeSet<TreeSet<Integer>> res, int n){
        if(index == n){
            res.add(new TreeSet<>(pr));
            return;
        }

        solve(arr, index+1, pr, res, n);
        pr.add(arr[index]);
        solve(arr, index+1, pr, res, n);
        pr.remove(pr.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int n) {
        TreeSet<TreeSet<Integer>> hs = new TreeSet<>();
        ArrayList<Integer> pr = new ArrayList<>();
        Arrays.sort(arr);
        solve(arr, 0, pr, hs, n);
        System.out.println(hs);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        return res;
    }
    public static void main(String[] args) {
        int [] arr = {2,2,1};
        ArrayList<ArrayList<Integer>> res = AllSubsets(arr, arr.length);
        System.out.println(res);
    }
}
