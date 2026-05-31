package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class GeneralisedAbbreviations {

    public static void solve(int i, int cnt, String s, String pr, ArrayList<String> res) {
        if(i== s.length()) {
            if (cnt == 0) {
                res.add(pr);
            } else {
                res.add(pr + cnt);
            }
            return;
        }
        solve(i+1, cnt+1,s,pr,res);
        if(cnt == 0){
            solve(i+1,0,s,  pr + s.charAt(i),res);
        }else{
            solve(i+1,0,s, pr + cnt + s.charAt(i),res);
        }

    }

    public static ArrayList< String > findAbbr(String str) {
        ArrayList< String > res = new ArrayList<>();
        solve(0, 0, str, "", res);
        Collections.sort(res);
        return res;
    }
    public static void main(String[] args) {
        System.out.println(findAbbr("abcd"));
    }
}
