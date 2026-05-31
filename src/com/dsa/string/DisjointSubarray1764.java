package com.dsa.string;

import java.util.ArrayList;
import java.util.List;

public class DisjointSubarray1764 {

    public int[] lps(int [] pat){
        int n = pat.length;
        int [] lps =  new int[n];
        int i=0;
        int j=1;
        while(j < pat.length){
            if(pat[i] == pat[j]){
                lps[j]=i+1;
                i++;
                j++;
            }else{
                if(i ==0){
                    lps[j]= 0;
                    j++;
                }else{
                    i = lps[i-1];
                }
            }
        }
        return lps;
    }

    public List<int[]> kmp(int [] s, int [] p){
        int [] lps =  lps(p);
        int i=0; // I am the pointer of pattern
        int j=0; // j is the pointer of text
        List<int[]> startEndPoints = new ArrayList<>();
        while (j < s.length ){
            if(p[i] == s[j]){
                i++;
                j++;
            }
            if(i == p.length){
                int [] startEndPoint = new int[]{j-i, j-1};
                startEndPoints.add(startEndPoint);
                i = lps[i-1];
            } else if(j < s.length && p[i] != s[j]){
                if(i == 0){
                    j++;
                }else{
                    i = lps[i-1];
                }
            }
        }
        return startEndPoints;
    }
    public boolean canChoose(int[][] groups, int[] arr) {
        int endIndex = -1;
        for (int i = 0; i < groups.length; i++) {
            int [] pat = groups[i];
            List<int[]> res  =  kmp(arr, pat);
            if(res.isEmpty()) return false;
            boolean isGreaterIndexPresent = false;
            for(int j=0; j < res.size(); j++){
                int []ithRes = res.get(j);
                if(ithRes[0] > endIndex){
                    endIndex = ithRes[1];
                    isGreaterIndexPresent = true;
                    break;
                }
            }
            if(!isGreaterIndexPresent){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        DisjointSubarray1764 ds = new DisjointSubarray1764();
        int [][] groups = {{1,-1,-1},{3,-2,0}};
        int arr[] = {1,-1,0,1,-1,-1,3,-2,0};
        System.out.println(ds.canChoose(groups, arr));


        int [][] groupsTwo = {{10,-2},{1,2,3,4}};
        int [] arrTwo = {1,2,3,4,10,-2};
        System.out.println(ds.canChoose(groupsTwo, arrTwo));


        int [][] groupsThree = {{1,2,3},{3,4}};
        int [] arrThree = {7,7,1,2,3,4,7,7};
        System.out.println(ds.canChoose(groupsThree, arrThree));

    }
}
