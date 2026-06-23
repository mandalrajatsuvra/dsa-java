package com.dsa.binary_serach_technique;

public class PeakElementGFG {

    public int binarySearch(int[] arr, int low, int high, int n){
        if(n== 1) return 0;
        if (low > high){
            return -1;
        }
        int mid = low + (high - low) / 2;
        if(mid == n - 1 && mid -1 >=0  && arr[mid] > arr[mid - 1]) {
            return mid;
        }
        else if(mid ==0 && mid +1 < n && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        else if(mid - 1 >= 0 && mid +1 < n  && arr[mid - 1] < arr[mid] &&  arr[mid] > arr[mid + 1]) {
            return mid;
        }else{
            int left = binarySearch(arr, low, mid - 1, n);
            if(left == -1){
                return binarySearch(arr, mid + 1, high, n);
            }else{
                return left;
            }
        }
    }


    public int peakElement(int[] arr) {
        return binarySearch(arr, 0, arr.length - 1, arr.length);
    }

    public static void main(String[] args) {
        int []a1 = {10, 20, 15, 2, 23, 90, 80};
        System.out.println(new PeakElementGFG().peakElement(a1));
        int [] a2 = {1, 2, 4, 5, 7, 8, 3};
        System.out.println(new PeakElementGFG().peakElement(a2));
        int [] a3 = {-1};
        System.out.println(new PeakElementGFG().peakElement(a3));
    }

}
