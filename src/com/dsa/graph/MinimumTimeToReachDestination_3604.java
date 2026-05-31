package com.dsa.graph;

import java.util.*;

public class MinimumTimeToReachDestination_3604 {
    // Correct solutions
    public int minTime(int n, int[][] edges) {
        ArrayList<int[]>[] G = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            G[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u =  edge[0];
            int v =  edge[1];
            int s =  edge[2];
            int e =  edge[3];
            G[u].add(new int[]{v,s, e});
        }
        int [] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{0,0});
        while (!queue.isEmpty()){
            int [] curr = queue.poll();
            int u = curr[0];
            int time = curr[1];
            for(int [] w: G[u]){
                int v = w[0];
                int s = w[1];
                int e = w[2];
                if(time >= s && time <= e){
                    if(distance[v] > time + 1){
                        distance[v] = time + 1;
                        queue.offer(new int[]{v, distance[v]});
                    }
                }else if(time < s ){
                    int newDistance = time + s - time + 1;
                    if(distance[v] > newDistance){
                        distance[v] = newDistance;
                        queue.offer(new int[]{v, distance[v]});
                    }
                }
            }
        }
        return distance[n-1] == Integer.MAX_VALUE ? -1 : distance[n-1];
    }

    public static void main(String[] args) {
        int [][] edges = new int[][]{
                {0,1,0,3},
                {1,3,7,8},
                {0,2,1,5},
                {2,3,4,7}
        };

        int n = 4;
        MinimumTimeToReachDestination_3604 min = new MinimumTimeToReachDestination_3604();
        System.out.println(min.minTime(n,edges));


        int [][] edges2 = new int[][]{
                {1,0,1,3},
                {1,2,3,5},
        };
        int n2 = 3;
        System.out.println(min.minTime(n2,edges2));

    }
}
