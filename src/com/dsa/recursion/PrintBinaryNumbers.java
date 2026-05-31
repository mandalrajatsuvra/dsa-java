package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryNumbers {
    public static void solve(int n, String pr, List<String> res){
        if(n==0) {
            res.add(new String(pr));
            return;
        }
        pr = '0' + pr;
        solve(n -1, pr, res);
        pr = pr.substring(1);
        pr = '1' + pr;
        solve(n -1, pr, res);
    }
    public static ArrayList<String> generateBinary(int n){
        ArrayList<String> resList = new ArrayList<>();
        solve(n, "", resList);
        return resList;
    }
    public static void main(String[] args) {
        System.out.println(generateBinary(4));
    }
}
