package com.dsa.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorderRoutesToMakeAllPathLeadToZero_1466 {

    public int minReorder(int n, int[][] connections) {
        ArrayList<int[]> []G = new ArrayList[n];
        for (int i = 0; i < n; i++){
            G[i] = new ArrayList<>();
        }
        for (int i = 0; i < connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            G[u].add(new int[]{v, 1});
            G[v].add(new int[]{u, 0});
        }

        Queue<Integer> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        queue.offer(0);
        int cnt = 0;
        while (!queue.isEmpty()){
            int u = queue.poll();
            for(int []edge: G[u]){
                int v = edge[0];
                int cost = edge[1];
                if(!visited[v]){
                    cnt += cost;
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        ReorderRoutesToMakeAllPathLeadToZero_1466 ob =  new ReorderRoutesToMakeAllPathLeadToZero_1466();
        int n = 6;
        int[][] connections = new int[][]{
                {0,1},
                {1,3},
                {2,3},
                {4,0},
                {4,5}
        };
        System.out.println(ob.minReorder(n, connections));
        int n2 = 5;
        int[][] connections2 = new int[][]{
                {1,0},
                {1,2},
                {3,2},
                {3,4}
        };

        System.out.println(ob.minReorder(n2, connections2));


    }

}
