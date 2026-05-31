package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutations2 {
    public static ArrayList<ArrayList<Integer>> f(int [] arr, int pos){
        if(pos == arr.length -1) {
            ArrayList<Integer> res  = new ArrayList<>();
            res.add(arr[pos]);
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> partialPermutations = f(arr, pos + 1);
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
        for(List<Integer> each: partialPermutations){
            List<Integer> finalEach = new ArrayList<>();
            finalEach.addAll(each);
            for(int i = 0; i <= each.size(); i++){
                finalEach.add(pos, arr[i]);
                permutations.add((ArrayList<Integer>) finalEach);
            }
        }
        return permutations;
    }
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4};
        List<List<Integer>> resList = new ArrayList<>();
        int [] cnt = new int[]{0};
        System.out.println( f(arr, 0));
        System.out.println(resList);
        System.out.println(cnt[0]);
    }
}
