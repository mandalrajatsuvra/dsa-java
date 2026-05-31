package com.dsa.string;

public class MaxRepeatingSubstring {

    public int[] lps(String p){
        int n = p.length();
        int [] lps = new int[n];
        int i = 0; //  pointer to the prefix
        int j = 1; // pointer to the suffix;
        while (j < n){
            if(p.charAt(j) == p.charAt(i)){
                lps[j] = i+1;
                i++;
                j++;
            }else{
                if(i==0){
                    lps[j]=0;
                    j++;
                }else{
                    i = lps[i-1];
                }
            }
        }
        return lps;
    }
    public int maxRepeating(String txt, String pat) {
        int cnt =0;
        int [] lps = lps(pat);
        int i=0; // pointer to the
        int j=0;
        while(j < txt.length()){
            if(pat.charAt(i) == txt.charAt(j)){
                i++;
                j++;
            }
            if(i==pat.length()){
                cnt++;
                i = lps[i-1];
            } else if(j < txt.length() && pat.charAt(i) != txt.charAt(j)) {
                if(i==0){
                    j++;
                }else{
                    i= lps[i-1];
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        MaxRepeatingSubstring mrs = new MaxRepeatingSubstring();
        System.out.println(mrs.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba","aaaba"));
    }
}
