package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceOfSumK {
    public static void f(int [] arr, int index, int sum, int k, List<Integer> pr, List<List<Integer>> res){
        if(index == arr.length){
            if(sum == k){
                res.add(new ArrayList<>(pr));
            }
            return;
        }
        pr.add(arr[index]);
        f(arr, index+1, sum + arr[index], k, pr, res);
        pr.remove(pr.size() -1);
        f(arr, index+1, sum, k, pr, res);
    }
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pr = new ArrayList<>();
        int arr[] = {1, 2,1, 1,  3};
        f(arr, 0, 0, 3, pr, res);
        System.out.println(res);
    }
}
