package com.dsa.string;

import java.util.ArrayList;
import java.util.List;

public class FindBeautifulIndicesInAnArray_3006 {

    public int[] lps(String pat){
        int [] lps =  new int[pat.length()];
        int i=0;
        int j=1;
        lps[0] = 0;
        while(j < pat.length()){
            if(pat.charAt(j)==pat.charAt(i)){
                lps[j] = i+1;
                i++;
                j++;
            }else{
                if(i ==0){
                    lps[j] =0;
                    j++;
                }else{
                    i= lps[i-1];
                }
            }
        }
        return  lps;
    }


    public List<Integer> searchAllOccurrences(String text, String pat){
        List<Integer> indices = new ArrayList<>();
        int [] lps = lps(pat);
        int i=0;// pointer to the pattern;
        int j=0; // pointer to the text;

        while(j < text.length()){
            if(text.charAt(j)==pat.charAt(i)){
                i++;
                j++;
            }
            if(i == pat.length()){
                indices.add(j-i);
                i = lps[i-1];
            }else if(j < text.length() && text.charAt(j)!=pat.charAt(i)){
                if(i ==0){
                    j++;
                }else{
                    i= lps[i-1];
                }
            }
        }
        return  indices;
    }

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> firstOccurrences =   searchAllOccurrences(s, a);
        List<Integer> secondOccurrences =   searchAllOccurrences(s, b);

        for(int i=0;i<firstOccurrences.size();i++){
            for(int j=0;j<secondOccurrences.size();j++){
                int  first = firstOccurrences.get(i);
                int second = secondOccurrences.get(i);
                if(Math.abs(first-second)<=k){
                    ans.add(first);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindBeautifulIndicesInAnArray_3006 ob = new FindBeautifulIndicesInAnArray_3006();
        System.out.println(ob.beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my", "squirrel", 15));



    }
}
