package com.dsa.greedy;

import java.util.Arrays;

public class LargestPerimeterTriangle {


    public int largestPerimeter(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=2; i<n; i++){
            if(nums[i-2] + nums[i-1] > nums[i]){
                res = Math.max(res, nums[i-2] + nums[i-1] + nums[i]);
            }
        }
        return res;
    }


}
