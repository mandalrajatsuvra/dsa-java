package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GrayCode {

    public static boolean isOneBitApart(int x, int y) {
       int bitDiff = x ^ y;
       return bitDiff != 0 && (bitDiff & bitDiff-1)==0;
    }

    public static boolean  grayCodeHelper(int n,  List<Integer> res, HashSet<Integer> hs){
        if(res.size() == (1 << n)){
            return isOneBitApart(res.get(0), res.get(res.size()-1));
        }
        for(int i=0; i<n ; i++){
            int lastDigit = res.get(res.size()-1);
            int code = lastDigit ^ (1<< i);
            if(!hs.contains(code)) {
                hs.add(code);
                res.add(code);
                if (grayCodeHelper(n, res, hs)) return true;
                res.remove(res.size() - 1);
                hs.remove(code);
            }
        }
        return false;
    }
    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        HashSet<Integer> hs = new HashSet<>();
        hs.add(0);
        grayCodeHelper(n, list, hs);
        return list;
    }
    public static void main(String[] args) {
        List<Integer> grayCodes = grayCode(3);
        System.out.println(grayCodes);
    }
}
