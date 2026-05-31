package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class PermutationsWithSpaces2 {

    public void solve(int pos, String s, ArrayList<String> res){
        if(pos >= s.length()){
            res.add(s);
            return;
        }
        for(int i= pos+1; i<= s.length(); i++){
            String prefix = s.substring(0,i);
            String suffix = s.substring(i);
            if(suffix.length() >= 1) {
                s = prefix + " " + suffix;
                solve(i+1, s, res);
                s = prefix + suffix;
            }else{
                s = prefix + suffix;
                solve(i, s, res);
                s = prefix + suffix;
            }
        }

    }
    ArrayList<String> permutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        solve(0, s, result);
        Collections.sort(result);
        return result;
    }
    public static void main(String[] args) {
        PermutationsWithSpaces2 p = new PermutationsWithSpaces2();
        System.out.println(p.permutation("ABCD"));
    }
}
