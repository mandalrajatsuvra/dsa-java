package com.dsa.binary_serach_technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndexAfterSorting_2089 {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int startIndex = -1;
        int endIndex = -1;

        List<Integer> result = new ArrayList<>();

        int low = 0;
        int high = n-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                startIndex = mid;
                high = mid - 1;
            }else if (nums[mid] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        if (startIndex == -1) {
            return result;
        }
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                endIndex = mid;
                low = mid + 1;
            }else if (nums[mid] < target) {
                low = mid + 1;
            }else  {
                high = mid - 1;
            }
        }
        for (int i = startIndex; i <= endIndex; i++) {
            result.add(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {

    }




}
