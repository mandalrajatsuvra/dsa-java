package com.dsa.binary_serach_technique;

public class FindFirstMissingGFG {



    /*
    *
    * Input: n = 5, m = 10, arr[] = [0, 1, 2, 6, 9]
    *
    * l = 0, r = 4 , m = 2
    * l =3, r = 4, m = 3, res = 3
    * l=3, r = 3 m = 3 res = 3;
    *
    *
    * [2, 3, 4, 5, 6]
    * l =0, r = 4 m = 2 arr[mid] = 4 != 2  res = 2
    *
    *
    *
    *
    * */
    public int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int res = n;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == mid) {
                low = mid+1;
            }else{
                res = mid;
                high = mid-1;
            }
        }
        return res;
    }

    public int findFirstMissing(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] != i) {
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {

    }
}
