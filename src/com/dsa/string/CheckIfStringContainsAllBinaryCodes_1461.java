package com.dsa.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckIfStringContainsAllBinaryCodes_1461 {

    
    
    
    // solution is correct but TLE
    public void generateAllString(int i, String s, int k, List<String> res){
        if(i==k){
            res.add(s);
            return;
        }
        generateAllString(i+1, s+"1", k, res);
        generateAllString(i+1, s+"0", k, res);
    }
    public boolean hasAllCodes(String s, int k) {
        List<String> allCodes = new ArrayList<>();
        generateAllString(0, "", k, allCodes);
        boolean hasAllCodes = true;
        for(String pat: allCodes){
            hasAllCodes = hasAllCodes && match(s, pat);
        }
        return hasAllCodes;
    }
    // Rolling Hash Problem Correct Solutions
    public boolean hasAllCodes2(String s, int k){
        /*
        *
        *    k = 5
        *
        *    s[0] * 2^4 + s[1]* 2^3 + s[2] * 2^ 2 + s[3] * 2^1 + s[4] * 2^0
        *
        *   // Rolling hash the number //
        *
        *
        * */
        int start =0;
        int n = s.length();
        if(n < k) return false;
        int sum = 0;
        for(int i=0; i <= k-1; i++){
            sum += (s.charAt(i)-'0') * Math.pow(2,k-i-1);
        }
        System.out.println(sum);
        Set<Integer> set = new HashSet<>();
        set.add(sum);
        for(int i= k; i < n; i++){
            sum = (sum - (s.charAt(start) -'0')* (int) (Math.pow(2, k - 1)))*2 + (s.charAt(i) - '0');
            start++;
            set.add(sum);
        }
        return set.size() == Math.pow(2,k);
    }
    
    public int [] lps(String pat){
        int [] lps =  new int[pat.length()];
        lps[0] = 0;
        int i=0;
        int j=1;
        while(j < pat.length()){
            if(pat.charAt(i) == pat.charAt(j)){
                lps[j] = i+1;
                i++;
                j++;
            }else{
                if(i ==0){
                    lps[j] = 0;
                    j++;
                }else{
                    i= lps[i-1];
                }
            }
        }
        return lps;
    }


    private boolean match(String text, String pat) {
        int [] lps = lps(pat);
        int m = text.length(), n = pat.length();
        int i=0; // pointer to the pattern
        int j=0; // pointer to the text
        while (j < m && i < n){
            if(text.charAt(j) == pat.charAt(i)){
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
        return i == n;
    }


    public static void main(String[] args) {
        CheckIfStringContainsAllBinaryCodes_1461 ob  = new CheckIfStringContainsAllBinaryCodes_1461();
        System.out.println(ob.hasAllCodes2("01001011", 2));
    }
}
