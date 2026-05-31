package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class PermutationsWithSpaces {



    public void solve(int pos , String s,  String pr, ArrayList<String> res){
        if(pos == s.length()){
            res.add(new String(pr));
            return;
        }
        if(pos == s.length()-1){
            solve(pos+1, s, pr+s.charAt(pos), res);
        }else{
            solve(pos+1, s, pr+s.charAt(pos)+" ", res);
            solve(pos+1, s, pr+s.charAt(pos), res);
        }

    }

    public ArrayList<String> permutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        solve(0, s, "", result);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        PermutationsWithSpaces p = new PermutationsWithSpaces();
        System.out.println(p.permutation("ABCD"));
    }
}
