package com.dsa.binary_serach_technique;

public class FindMissingElementsGFG {
    // Incomplete
    public int findMissing(int[] arr) {
        int n = arr.length;

        int start = 0;
        int end = n-1;
        /*
        *
        * Input: arr[] = [1, 6, 11, 16, 21, 31]
          Output: 26
          * s = 0, e= 5 m = 2 lcd = 2 rcd = 6.5
          * s = 3, e= 5 m = 4 lcd = 5 rcd = 10
        *
        *
        *
        *
        * arr[] = [2, 4, 8, 10, 12, 14]
        * s = 0 e = 5 m = 2
        *
        *
        * */
        while(start <= end){
            int mid = start + (end-start)/2;
            double lcd = (double) (arr[mid] - arr[start])/(double) (mid - start);
            double rcd = (double) (arr[end] - arr[mid])/(double) (end - mid);
            if(start == end-1){
                return (arr[start] + arr[end])/2;
            }
            if(lcd <= rcd){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return arr[0] + (start + 1) * Math.min (arr[1] - arr[0], arr[arr.length-1] - arr[arr.length-2]);
    }

    public static void main(String[] args) {

    }
}
