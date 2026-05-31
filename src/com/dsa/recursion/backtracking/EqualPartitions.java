package com.dsa.recursion.backtracking;

import java.util.ArrayList;

public class EqualPartitions {

    public boolean solve(int index, int []arr, int target, boolean[] used, ArrayList<Integer> res){
        if(index==arr.length){
            if(res.size()==arr.length/2) {
                return target == 0;
            }
            return false;
        }
        used[index] = true;
        res.add(arr[index]);
        if(solve(index + 1, arr, target- arr[index], used, res)) return true;
        used[index] = false;
        res.remove(res.size()-1);
        return solve(index + 1, arr, target, used, res);
    }

    public ArrayList<ArrayList<Integer>> equalPartition(int[] arr) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        ArrayList<Integer> firstHalf = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        solve(0, arr, sum/2, used, firstHalf);
        ArrayList<Integer> secondHalf = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(!used[i]){
                secondHalf.add(arr[i]);
            }
        }
        resList.add(firstHalf);
        resList.add(secondHalf);
        return resList;
    }

    public static void main(String[] args) {
        EqualPartitions ep = new EqualPartitions();
        int [] arr = {3,4, 5, -3, 100, 1, 89, 54, 23, 20};
        ArrayList<ArrayList<Integer>> res = ep.equalPartition(arr);
        System.out.println(res);

    }
}
