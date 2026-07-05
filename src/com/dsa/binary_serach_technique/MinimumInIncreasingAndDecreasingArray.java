package com.dsa.binary_serach_technique;

public class MinimumInIncreasingAndDecreasingArray {

    /*
    *
    * Input: arr[] = [9, 7, 5, 2, 4, 6, 10]
Output: 3
Explanation: The minimum of the given array is 2, which is at index 3.
    *
    *  n = 7
    *
    *  l =1 r = 5 m = 3  arr[3] = 2
    *  l=1 r = 3  m = 2 arr[2] = 5
    *
    *  l = 3 r =3
    *
    *  10, 8, 6, 5, 2, 12, 14
    * n = 7
    * l =1 r= 5 m = 3 arr[m] = 5
    *  l = 4 r =5  m = 4 a[m] = 2
    * r = 4;
    *
    * 10 5 3, 2, 1 0
    * n = 6
    * l=1 r = 4 m = 2 a[2] = 3 > arr[m+1]
    * l = 3 r = 4 m = 3 a[m] = 2 > a[m+1]
    * l = 4 r =4  m = 4
    * left 5
    *
    * 0 1 2 3 4 5 6 7
    * n = 8
    * l=1 r= 6 m = 3 a[m] = 3 < a[m+1]
    * l=1, r = 3 m = 2
    * l =1 , 2 m = 1
    *
    *
    *
    *
    * */


    public int findMinIndex(int[] arr) {
        if(arr.length==1){
            return 0;
        }
        if(arr.length==2){
            return arr[0] < arr[1] ? 0 : 1;
        }
        int n = arr.length;
        int left = 0;
        int right = n-2;

        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid]<arr[mid+1]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {

    }
}
