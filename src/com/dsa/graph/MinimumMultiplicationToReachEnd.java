package com.dsa.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationToReachEnd {

    int minimumMultiplications(int[] arr, int start, int end) {
        int MOD = (int)1e5;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});
        HashSet<Integer> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            int [] cur = queue.poll();
            int data = cur[0];
            int minMultiplications = cur[1];
            if(data == end){
                return minMultiplications;
            }else if(data > end){
                continue;
            }
            for(int i = 0; i < arr.length; i++){
                if(!visited.contains((data * arr[i]) % MOD)) {
                    visited.add((data * arr[i]) % MOD);
                    queue.offer(new int[]{(data * arr[i]) % MOD, minMultiplications + 1});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        MinimumMultiplicationToReachEnd minimumMultiplicationToReachEnd = new MinimumMultiplicationToReachEnd();
        int [] arr = {3, 4, 65};
        int start = 7;
        int end = 66175;

        System.out.println(minimumMultiplicationToReachEnd.minimumMultiplications(arr, start, end));


    }
}
