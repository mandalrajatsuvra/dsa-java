package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutations {
    public static void generatePermutations(int [] arr, int index, List<Integer> pr, List<List<Integer>> res, int[] cnt){
        if(index == arr.length){
            res.add(new ArrayList<>(pr));
            cnt[0] ++;
            return;
        }
        for(int it = index ; it< arr.length; it ++){
            pr.add(arr[it]);
            swap(index, it, arr);
            generatePermutations(arr, index+1, pr, res, cnt);
            swap(index, it, arr);
            pr.remove(pr.size() - 1);
        }
    }

    private static void swap(int index, int it, int[] arr) {
        int temp = arr[it];
        arr[it] = arr[index];
        arr[index] = temp;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4};
        List<List<Integer>> resList = new ArrayList<>();
        int [] cnt = new int[]{0};
        generatePermutations(arr, 0, new ArrayList<>(), resList, cnt);
        System.out.println(resList);
        System.out.println(cnt[0]);
    }
}
