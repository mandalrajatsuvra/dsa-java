package com.dsa.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMPAlgorithms {

    public static int [] lps(String pat){
        int n =  pat.length();
        int [] lps = new int[n];
        int i=0;
        int j=1;
        lps[0]=0;
        while (j < n){
            if(pat.charAt(i) == pat.charAt(j)){
                lps[j] = i + 1;
                i++;
                j++;
            }else{
                if(i != 0) {
                    i = lps[i - 1];
                }else{
                    lps[i] = 0;
                    j++;
                }

            }
        }
        return lps;
    }
    public static List<Integer> kmp(String s, String p){
        int [] lps = lps(p);
        List<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(i < s.length()){
            if (j == p.length()) {
                ans.add(i-j);
            }
            if(j< p.length() &&  s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            } else{
                if(j != 0) {
                    j = lps[j - 1];
                }else{
                    i++;
                }
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(lps("ababaca")));
        System.out.println(Arrays.toString(lps("ABCABDABCABCABD")));
        System.out.println(kmp("ababaca","aba"));
    }
}
