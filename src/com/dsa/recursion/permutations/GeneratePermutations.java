package com.dsa.recursion.permutations;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutations {


    public static void generatePermutations(int [] arr, List<Integer> pr, List<List<Integer>> res, boolean [] marked){
        if(pr.size() == arr.length){
            res.add(new ArrayList<>(pr));
            return;
        }
        for(int i=0; i< arr.length; i++){
            if(!marked[i]){
                marked[i] = true;
                pr.add(arr[i]);
                generatePermutations(arr, pr, res, marked);
                marked[i] = false;
                pr.remove(pr.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int arr [] = {1, 2,3};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pr = new ArrayList<>();
        boolean [] marked = new boolean[arr.length];
        generatePermutations(arr, pr, res, marked);
        System.out.println(res);
    }
}
