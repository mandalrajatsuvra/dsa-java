package com.dsa.binary_serach_technique;

public class LowerBoundGFG {


   /* Input:  arr[] = [2, 3, 7, 10, 11, 11, 25], target = 9
    Output: 3
    Explanation: 3 is the smallest index in arr[] where element (arr[3] = 10) is greater than or equal to 9.*/

    public  int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] >=  target) {
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res == -1? arr.length : res;
    }

    public static void main(String[] args) {

    }
}
