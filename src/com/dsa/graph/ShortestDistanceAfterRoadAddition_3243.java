package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceAfterRoadAddition_3243 {
    // Correct algo
    public int bfs(int start, int end, ArrayList<Integer>[] graph, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(new int[] {start, 0});
        visited[start] = true;
        while (!queue.isEmpty()) {
            int []node =  queue.poll();
            int u = node[0];
            int d = node[1];
            if (u == end) {
                return d;
            }
            for(int v: graph[u]) {
                if(!visited[v]) {
                    visited[v] = true;
                    queue.add(new int[] {v, d+1});
                }
            }
        }
        return -1;
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int u=1; u< n; u++){
            graph[u-1].add(u);
        }
        int noOfQueries = queries.length;
        int []res =  new int[noOfQueries];
        for(int i=0;i<noOfQueries;i++){
            int u = queries[i][0];
            int v = queries[i][1];
            graph[u].add(v);
            res[i] = bfs(0,n-1,graph,n);
        }
        return res;
    }
    public static void main(String[] args) {
        ShortestDistanceAfterRoadAddition_3243 s = new ShortestDistanceAfterRoadAddition_3243();
        int n1 = 5;
        int [][]queries1 = {{2,4}, {0,2}, {0,4} };
        System.out.println(Arrays.toString( s.shortestDistanceAfterQueries(n1,queries1)));

        int n2 = 4;
        int [][]queries2 = {{0,3}, {0,2}};
        System.out.println(Arrays.toString( s.shortestDistanceAfterQueries(n2,queries2)));

    }
}
