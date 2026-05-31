package com.dsa.string;

import java.util.ArrayList;
import java.util.List;

public class TheNaiveStringMatchingAlgo {
    /*
    *
    *    ababcdabac
    *          abac
    *
    *
    *
    * */
    public List<Integer> matchingStrings(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length(), n = p.length();
        for(int i=0; i<= m-n; i++){
            int k = i;
            int j = 0;
            while(j < n && s.charAt(k) ==  p.charAt(j)){
                k++;
                j++;
            }
            if(j == n){
                res.add(i);
            }
        }
        return res;
    }
    public List<Integer> matchingStringsWithSlidingWindow(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length(), n = p.length();
        int start = 0; int end = 0;
        String segment = "";
        while(end < m){
            segment +=  s.charAt(end);
            if(end-start+1 < n){
                end ++;
            }else if(end-start+1 == n){
                if(segment.equals(p)){
                    res.add(start);
                }
                segment = segment.substring(1);
                start ++;
                end ++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TheNaiveStringMatchingAlgo theNaiveStringMatchingAlgo = new TheNaiveStringMatchingAlgo();
        System.out.println(theNaiveStringMatchingAlgo.matchingStrings("abaccdabac", "abac"));
        System.out.println(theNaiveStringMatchingAlgo.matchingStringsWithSlidingWindow("abaccdabac", "abac"));
    }
}
