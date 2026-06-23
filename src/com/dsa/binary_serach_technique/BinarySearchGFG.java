package com.dsa.binary_serach_technique;

public class BinarySearchGFG {
    public boolean binarySearch(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                return true;
            }else if (arr[mid] < k) {
                low = mid + 1;
            }else  {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
