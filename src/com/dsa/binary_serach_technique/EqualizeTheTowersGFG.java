package com.dsa.binary_serach_technique;

public class EqualizeTheTowersGFG {
    /*
    *
    *Input: heights[] = [1, 2, 3], cost[] = [10, 100, 1000]
      Output: 120
      *
      * l = 1 h = 3 m = 2 lowerCost = 10 higherCost = 1000 ans = 1010
    *
    *   l = 3, h = 3 m = 3 lowerCost = 120 higherCost = 0 and 120
    *   l = 3 h = 2
    *
    *   Input: heights[] = [7, 1, 5], cost[] = [1, 1, 1]
    *
    *   Output: 6
    *
    * l =1 h = 7 , m = 4 lowerCost = 3 higherCost = 4 res = 7
    *
    * l = 5 h = 7  m = 6 lowerCost = 5 higherCost = 1 res = 6
    *
    *l =5 h = 5 m = 5  lowerCost = 4  higherCost = 2  res = 6
    *
    *
    *  height =
    *
    *   2 2 5
        5 4 5
    *
    * l = 2 h = 5 m = 3 lesserCost = 9  higherCost = 10 and = 19
    * l = 4, h = 5 m = 4 ,
    *
    *
    *
    *
    *
    *
    * */
    public int minCost(int[] heights, int[] cost) {
        int low =  heights[0];
        int high = heights[0];
        for(int i = 0; i < heights.length; i++){
            low = Math.min(low, heights[i]);
            high = Math.max(high, heights[i]);
        }
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high) >> 1;
            int [] costLesserAndHigher = getCostLesserAndHigher(heights, cost, mid);
            int lesserCost =  costLesserAndHigher[0];
            int higherAndEqualCost = costLesserAndHigher[1];
            ans = Math.min(ans, lesserCost + higherAndEqualCost);
            if(lesserCost > higherAndEqualCost){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private int[] getCostLesserAndHigher(int[] heights, int[] cost, int mid) {
        int lesserCost = 0;
        int higherOrEqualCost = 0;
        for(int i = 0; i < heights.length; i++){
            if(heights[i] < mid){
                lesserCost +=  (mid- heights[i]) * cost[i];
            }else{
                higherOrEqualCost +=  (heights[i]-mid) * cost[i];
            }
        }
        return new int[]{lesserCost, higherOrEqualCost};
    }

    public static void main(String[] args) {

    }
}
