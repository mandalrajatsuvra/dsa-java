package com.dsa.binary_serach_technique;

import java.util.Arrays;



public class SpecialArrayWithXElementsGreaterThanOrEqualX_1608 {

    /*
    * DRY RUN
    *
    * [0, 4 , 3, 0, 4]
    * [0, 0, 3, 4, 4]   -->  0, 4 , mid = 2, arr[2] >= 2 (0,1) --> 0+1/2 = 0 (1,1) => mid 1 (2, 1)
    *  l= 0, h = 4 , mid = 2 , 3 (3, 4)
    *
    * */

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int low =0;
        int high = nums.length;

        while(low <= high){
            int mid = (low+high)/2;
            int numbersAreGreaterThanMid = search(nums, mid);
            if(mid == numbersAreGreaterThanMid){
                return mid;
            }else if(numbersAreGreaterThanMid > mid){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    private int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int pos = -1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] >= target){
                pos = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return  pos == -1 ? pos : arr.length - pos;
    }
    public static void main(String[] args) {

    }
}
