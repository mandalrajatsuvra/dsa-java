package com.dsa.greedy;


/*
*     i
*     i       1
*     i     1 1
*     i  1  1 1
*     1  4  5 6
*
* */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumNoOfMoves {
    // Wrong answer thing correctly
    public static int minCostToMoveChips(int[] position) {

        Map<Integer, Integer> freq = new HashMap<>();
        for(int pos : position){
            freq.put(pos, freq.getOrDefault(pos, 0) + 1);
        }
        // FIRST element of the miHeap is freq and second element is pos
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int maxFreq = Integer.MIN_VALUE;
        int pos = -1;
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            minHeap.add(new int[]{entry.getValue(), entry.getKey()});
            if(entry.getValue() > maxFreq){
                maxFreq = entry.getValue();
                pos = entry.getKey();
            }
        }
        int cost = 0;
        while ( minHeap.size() >= 1 ){
            int [] top =  minHeap.poll();
            if(Math.abs(pos- top[1]) % 2  != 0 ){
                cost += top[0];
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        System.out.println(minCostToMoveChips(arr));
    }
}
