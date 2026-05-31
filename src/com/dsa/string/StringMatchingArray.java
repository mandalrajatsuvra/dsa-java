package com.dsa.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringMatchingArray {

    public int[] lps(String p){
        int [] lps =  new int[p.length()];
        lps[0] = 0;
        int i=0; // this is prefix pointer
        int j=1; // this is suffix pointer
        while (j < p.length()){
            if(p.charAt(j)==p.charAt(i)){
                lps[j] = i+1;
                i++;
                j++;
            }else{
                if(i == 0){
                    lps[j] = 0;
                    j++;
                }else{
                    i= lps[i-1];
                }
            }
        }
        return lps;
    }
    public boolean kmp(String s, String p){
        int [] lps =  lps(p);
        int i=0;// pointer to pattern
        int j=0; // pointer to the text;
        while (i < p.length() && j < s.length()){
            if(p.charAt(i) == s.charAt(j)){
                i++;
                j++;
            }else{
                if(i==0){
                    j++;
                }else{
                    i = lps[i-1];
                }
            }
        }
        return i == p.length();
    }
    public List<String> stringMatching(String[] words) {
        HashSet<String> ans = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(i != j && kmp(words[i], words[j])){
                    ans.add(words[j]);
                }
            }
        }
        return new ArrayList<>( ans);
    }
    public static void main(String[] args) {
        StringMatchingArray sma = new StringMatchingArray();
        String [] arr = {"mass","as","hero","superhero"};
        System.out.println(sma.stringMatching(arr));
        String [] arr2 = {"leetcode","et","code"};
        System.out.println(sma.stringMatching(arr2));

    }
}
