package com.dsa.greedy;

import java.util.Arrays;

public class NoOfArrowsToBurstBallons {

    /*                      --------------------------
    *       -----------------------------------------
    *     ----------     ------------------------
    *  ----
    *points = [[10,16],[2,8],[1,6],[7,12]]
    *
    * [[1,6],[2,8] ,[7,12], [10,16]]
    *
    * cnt = 2 end = 12
    *
    * [[1,2],[3,4],[5,6],[7,8]]
    *
    *
    *
    * [[1,2],[2,3],[3,4],[4,5]]
    * end = 2 , end 4
    * */


    public int findMinArrowShots(int[][] points) {
        int cnt = 1;
        Arrays.sort(points, (a,b)->a[1]-b[1]);
        int n = points.length;
        int end = points[0][1];
        for(int i = 1; i < n; i++){
            if(points[i][0] <= end){
                end = Math.min(end, points[i][1]);
            }else{
                cnt++;
                end = Math.max(end, points[i][1]);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] arr1 = {
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };

        int[][] arr2 = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };

        int[][] arr3 = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };


        NoOfArrowsToBurstBallons b = new NoOfArrowsToBurstBallons();
        System.out.println(b.findMinArrowShots(arr1));
        System.out.println(b.findMinArrowShots(arr2));
        System.out.println(b.findMinArrowShots(arr3));
    }
}
