package com.dsa.binary_serach_technique;

import java.util.Arrays;

public class MissingNumber_268 {


    public int search(int[] nums, int target) {

        int  low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            if(search(nums, i) == -1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
