package com.dsa.recursion.permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class GenerateAllPermutations {
    public static void solve(char[] arr, String pr, int[] used, HashSet<String> resList){
        if(arr.length == pr.length()){
            resList.add(new String(pr));
            return;
        }
        for(int i=0; i< arr.length; i++){
            char c = arr[i];
            if(used[c -'A'] > 0){
                used[c - 'A']--;
                pr += c;
                solve(arr, pr, used, resList);
                used[c - 'A'] ++;
                pr = pr.substring(0, pr.length() - 1);
            }
        }
    }
    public static List<String> generateAllPermutations(String s){
        HashSet<String> resList = new HashSet<>();
        int [] used = new int[26];
        for(int i =0; i< s.length(); i++){
            used[s.charAt(i)- 'A']++;
        }
        solve(s.toCharArray(), "", used, resList);
        List<String> res = new ArrayList<>(resList);
        Collections.sort(res);
        return res;
    }
    public static void main(String[] args) {
        System.out.println(generateAllPermutations("ABB"));
    }
}
