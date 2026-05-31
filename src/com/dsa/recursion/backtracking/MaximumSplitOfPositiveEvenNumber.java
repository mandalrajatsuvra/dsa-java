package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MaximumSplitOfPositiveEvenNumber {


    public boolean solve(long s, HashSet<Long> used, List<Long> ans){
        if(s==0){
            return true;
        }else if(s < 0){
            return false;
        }

        for(long i=2; i<= s; i+=2){
            if(!used.contains(i)){
                if(i <= s){
                    used.add(i);
                    ans.add(i);
                    if(solve(s -i, used, ans)) return true;
                    used.remove(i);
                    ans.remove(i);
                }
            }
        }
        return false;
    }
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        solve(finalSum, new HashSet<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        MaximumSplitOfPositiveEvenNumber m = new MaximumSplitOfPositiveEvenNumber();
        System.out.println(m.maximumEvenSplit(7));
    }
}
