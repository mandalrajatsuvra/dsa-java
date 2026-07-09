package com.dsa.binary_serach_technique;

public class SumOfTheMiddleElementsTwoSortedArrayGFG {
    // correct answer
    public int sumOfMiddleElements(int[] arr1, int[] arr2) {
        int n =  arr1.length;
        int low = 0, hi = n;
        while (low <= hi){
            int mid = low + (hi - low) / 2;

            int l1 = mid-1  >= 0 ? arr1[mid-1] : Integer.MIN_VALUE;
            int r1 = mid < n ? arr1[mid] : Integer.MAX_VALUE;
            int l2 = n - mid > 0 ? arr2[n-mid-1] : Integer.MIN_VALUE;
            int r2 = n - mid < n ? arr2[n-mid] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2) + Math.min(r1,r2) ;
            }else if(l1 > r2){
                hi = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

}
