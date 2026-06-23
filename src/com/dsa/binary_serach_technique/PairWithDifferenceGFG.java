package com.dsa.binary_serach_technique;

import java.util.HashSet;

public class PairWithDifferenceGFG {

    public boolean findPair(int[] arr, int x) {
        HashSet<Integer> set = new HashSet<>();
        for(int t: arr){
            if(set.contains(t-x) || set.contains(x + t)){
                return true;
            }
            set.add(t);
        }
        return false;
    }

    public static void main(String[] args) {

    }


}
