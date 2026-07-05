package com.dsa.binary_serach_technique;

public class CeilingOfSortedArray {


    public int findCeil(int[] arr, int x) {
        int n =  arr.length;
        int left = 0;
        int right = n-1;
        int ceiling = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] >= x) {
                ceiling = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ceiling;
    }

}
