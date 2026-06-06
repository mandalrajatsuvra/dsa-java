package com.dsa.binary_serach_technique;

public class SearchInsertPosition_35 {

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int insertPos = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                insertPos = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return insertPos == -1 ? low : insertPos;
    }
}
