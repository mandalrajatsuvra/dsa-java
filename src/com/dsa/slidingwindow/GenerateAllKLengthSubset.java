package com.dsa.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllKLengthSubset {
    public static List<String> generateAllString(int []arr, int k) {
        List<String> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        String s = "";
        while (end < arr.length) {
            if(!s.isEmpty() && s.substring(s.length()-1).equals(String.valueOf(arr[end]))){
                s = "";
                start = end;
                continue;
            }
            s += String.valueOf(arr[end]);
            if (end - start + 1 > k) {
                s = s.substring(1);
                start++;
            }
            if (end - start + 1 == k) {
                list.add(s);
            }
            end++;
        }
        return list;
    }
    public static void main(String[] args) {
        int [] arr ={1,0,0,1,0,1,1} ;
        System.out.println(generateAllString(arr, 3));
    }
}
