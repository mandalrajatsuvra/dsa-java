package com.dsa.binary_serach_technique;

public class MissingNumberGFG {

    public int missingNumber(int arr[]) {
        int n = arr.length;
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = (low + high) / 2;
            if(arr[mid-1] == mid){
                low = mid + 1;
            }else if(arr[mid-1] > mid){
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        MissingNumberGFG obj = new MissingNumberGFG();
        int arr [] = {1, 2, 3, 4, 5, 6, 8, 9};
        System.out.println(obj.missingNumber(arr));
    }
}
