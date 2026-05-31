package com.dsa.recursion.permutations;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutationsString {

    public static void generatePermutationsString(char[] arr, String pr, List<String> res, boolean[] marked){
        if(pr.length() == arr.length){
            res.add(new String(pr));
            return;
        }
        for(int i=0; i< arr.length; i++){
            if(!marked[i]){
                marked[i] = true;
                generatePermutationsString(arr, pr + arr[i], res, marked);
                marked[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        String str = "ABC";
        boolean [] marked = new boolean[str.length()];
        List<String> res = new ArrayList<>();
        generatePermutationsString(str.toCharArray(), "",res, marked );
        System.out.println(res);
    }
}
