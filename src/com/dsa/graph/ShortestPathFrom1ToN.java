package com.dsa.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathFrom1ToN {

    public int minStep2(int u , int n, boolean[] visited, int []dp){

        if(u > n) return (int)1e9;
        if(u == n) return 0;
        visited[u] = true;
        if(dp[u] != -1) return dp[u];
        int plusOne = 1+ minStep2(u+1, n, visited, dp);
        int multiplyThree = 1+ minStep2(u*3, n, visited, dp);
        visited[u] = false;
        return dp[u] = Math.min(plusOne, multiplyThree);
    }


    public int minStep(int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 0});
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int [] cur = queue.poll();
            int data = cur[0];
            int step = cur[1];
            if(data == n){
                return step;
            }else if(data > n){
                continue;
            }
            if(!visited.contains(data+1)) {
                visited.add(data + 1);
                queue.offer(new int[]{data + 1, step + 1});
            }

            if(!visited.contains(data *3)) {
                visited.add(data * 3);
                queue.offer(new int[]{data * 3, step + 1});
            }

        }


        return -1;







    }

    public static void main(String[] args) {

    }
}
