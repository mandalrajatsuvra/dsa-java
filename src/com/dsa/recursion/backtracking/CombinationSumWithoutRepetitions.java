package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSumWithoutRepetitions {

    public void solve(int i, int [] arr, int target,  ArrayList<Integer> pr,  HashSet<ArrayList<Integer>> result) {
        if(i == arr.length && target == 0){
            ArrayList<Integer> list = new ArrayList<>(pr);
            Collections.sort(list);
            result.add(list);
            return;
        }else if(i == arr.length){
            return;
        }

        pr.add(arr[i]);
        solve(i+1,arr,target-arr[i],pr,result);
        pr.remove(pr.size()-1);
        solve(i+1,arr,target,pr,result);

    }

    public ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {
        HashSet<ArrayList<Integer>> result = new HashSet<>();
        solve(0,arr,target,new ArrayList<>(),result);
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        CombinationSumWithoutRepetitions c = new CombinationSumWithoutRepetitions();
        int []arr = {4, 1, 1, 3, 4};
        int target = 5;
        ArrayList<ArrayList<Integer>> result = c.uniqueCombinations(arr,target);
        System.out.println(result);
    }
}
