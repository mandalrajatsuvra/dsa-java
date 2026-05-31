package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class CombinationSum {
    public static void solve(ArrayList<Integer> A, int ind, int B, LinkedList<Integer> pr, ArrayList<ArrayList<Integer>> res){
        if(ind == A.size()){
            if(B == 0) {
                res.add(new ArrayList<>(pr));
            }
            return;
        }
        if(B >= A.get(ind)) {
            pr.addLast(A.get(ind));
            solve(A, ind, B - A.get(ind), pr, res);
            pr.removeLast();
            solve(A, ind + 1, B, pr, res);
        }else{
            solve(A, ind + 1, B, pr, res);
        }
    }
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        solve(A, 0, B, new LinkedList<>(), resList);
        return resList;
    }
    public static void main(String[] args) {
        int arr[] = {7,2,6,5};
        ArrayList<Integer> in = Arrays.stream(arr)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(combinationSum(in, 16));

    }
}
