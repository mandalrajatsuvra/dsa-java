package com.dsa.binary_serach_technique;

public class SearchInRotatedSortedArray_33 {


    public int minIndex(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }

    public int search(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                low = mid + 1;
            }else  {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int minIndex = minIndex(nums);
        int index = search(nums, minIndex, nums.length - 1, target);
        if (index == -1) {
            return search(nums, 0, minIndex-1, target);
        }else{
            return index;
        }
    }
    public static void main(String[] args) {

    }
}
