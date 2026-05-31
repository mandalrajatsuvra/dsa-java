package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayInFibonacciSequence {



    public boolean isFib(List<Integer> arr){
        if(arr.size() < 3) return false;
        for(int i=2; i< arr.size(); i++){
            if(arr.get(i) != arr.get(i-1)+ arr.get(i-2)){
                return false;
            }
        }
        return true;

    }
    public boolean solve(int pos, String s, List<Integer> arr){
        if(pos == s.length()){
            return isFib(arr);
        }
        for(int i=pos+1; i <=  s.length(); i++){
                String prefix = s.substring(pos, i);
                if(prefix.length() > 10 || Long.parseLong(prefix) > Integer.MAX_VALUE ){
                    continue;
                }
                if((arr.size() >= 2 && Long.parseLong(prefix) != arr.get(arr.size()-1) + arr.get(arr.size()-2))) continue;
                if (!(prefix.charAt(0) == '0' && prefix.length() > 1)) {
                    arr.add(Integer.parseInt(prefix));
                    if (solve(i, s, arr)) return true;
                    arr.remove(arr.size() - 1);
                }
        }
        return false;
    }



    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> ans = new ArrayList<>();
        solve(0, num, ans);
        return ans;
    }

    public static void main(String[] args) {
        SplitArrayInFibonacciSequence s =  new SplitArrayInFibonacciSequence();
        List<Integer> ans = s.splitIntoFibonacci("214748364721474836422147483641");
        System.out.println(s.splitIntoFibonacci("123456579"));
        System.out.println(ans);
    }
}
