package com.dsa.binary_serach_technique;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementInTheRangeGFG {

    public int findLowerBound(int[] arr, int x) {
        int start = 0;
        int end = arr.length-1;
        int lowerBound = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid] <= x){
                lowerBound = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return lowerBound;
    }
    public int findUpperBound(int []arr, int x){
        int low = 0;
        int high = arr.length-1;
        int upperBound = -1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(arr[mid] >= x){
                upperBound = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return upperBound;
    }
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        Arrays.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();
        for(int [] query:queries){
            int low = findUpperBound(arr,query[0]);
            int high = findLowerBound(arr,query[1]);
            if(low == -1 || high == -1){
                res.add(0);
            }else{
                res.add(high-low+1);
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
