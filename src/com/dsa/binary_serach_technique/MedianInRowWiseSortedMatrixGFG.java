package com.dsa.binary_serach_technique;

/*
*
*
* Input: mat[][] = [[2, 4, 9],
                    [3, 6, 7],
                    [4, 7, 10]]
Output: 6
Explanation: Sorting matrix elements gives us [2, 3, 4, 4, 6, 6, 6, 6,6 ,6 6, 7, 7, 9, 10]. Hence, 6 is median.
*
*
*
* */


public class MedianInRowWiseSortedMatrixGFG {


    public int median(int[][] mat) {
        int r =  mat.length;
        int c = mat[0].length;
        int st = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i=0; i< r; i++){
            st = Math.min(st,mat[i][0]);
            end = Math.max(end,mat[i][c-1]);
        }
        while (st < end){
            int mid = st + (end-st)/2;
            int total = 0;
            for(int i=0; i<mat.length; i++){
                 total += upperBound(mat[i], mid);
            }
            if(total >= (r*c+1)/2){
                end = mid;
            }else{
                st = mid+1;
            }
            //[2, 3, 4, 4, 6,
            // 6, 6, 6,6 ,6
            // 6, 7, 7, 9, 10].
            //1, 2, 3,
            //3, 5, 6,
            //6, 9, 9
            /*
            * s = 1 e = 9 m = 5   -- 4   <= 4
            * st = 5, e = 9 m =7  --7
            * st =5 , e = 6 m = 5  --4 <=4
            *
            * [2, 3, 4, 4, 6, 6, 6, 6,6 ,6 6, 7, 7, 9, 10].
            *
            * s = 2 e = 10 m = 6 --4
            * s = 6 e = 10 m = 8
            * s= 6 e = 7 m = 6
            * s = 6 e = 6
            * [2, 3, 4, 4, 6, 7, 7, 9, 10]
            *
            * s = 2 e = 10 m = 6
            *
            *
            *
            * */
            //

        }
        return st;
    }


    public int upperBound(int [] arr, int key){
        int start = 0;
        int end = arr.length-1;
        int upperBoundIndex = arr.length;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] > key){
                upperBoundIndex = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return upperBoundIndex;
    }
}
