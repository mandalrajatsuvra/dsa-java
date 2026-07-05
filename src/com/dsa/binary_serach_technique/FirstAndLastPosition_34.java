package com.dsa.binary_serach_technique;

public class FirstAndLastPosition_34 {

    public int firstOccurrence(int [] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int res = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                res = mid;
                end = mid-1;
            }else if(arr[mid] < target){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return res;
    }
    public int lastOccurrence(int [] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int res = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                res = mid;
                start = mid+1;
            }else if(arr[mid] < target){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return res;
    }
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[]{-1,-1};
        res[0] = firstOccurrence(nums, target);
        res[1] = lastOccurrence(nums, target);
        return res;
    }

}
