package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
//Correct solutions
public class NoOfRestrictedPathFromFirstToLast_1786 {

    public ArrayList<int[]>[] createGraph(int n , int [][] edges) {
        ArrayList<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u =  edges[i][0]-1;
            int v =  edges[i][1]-1;
            int w = edges[i][2];
            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u,w});
        }
        return graph;
    };

    public int dfs(int s, int d, boolean[] visited, int [] distance, ArrayList<int[]>[] G) {
        if(s == d){
            return 1;
        }
        visited[s] = true;
        int res = 0;
        for(int []node: G[s]){
            int v = node[0];
            if(!visited[v]){
                if(distance[s] > distance[v]){
                    res +=  dfs(v,d,visited,distance,G);
                }
            }
        }
        visited[s] = false;
        return res;
    }


    public int countRestrictedPaths(int n, int[][] edges) {
        ArrayList<int[]>[] G = createGraph(n, edges);
        int [] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[n-1] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{n-1,0});
        while (!minHeap.isEmpty()) {
            int [] node = minHeap.poll();
            int u = node[0];
            int w =  node[1];
            for(int[] edge: G[u]) {
                int v = edge[0];
                int wt =  edge[1];
                if(distance[v] > distance[u] + wt) {
                    distance[v] = distance[u] + wt;
                    minHeap.offer(new int[]{v, distance[v]});
                }
            }
        }
        boolean[] visited = new boolean[n];
        return dfs(0, n-1, visited, distance, G);
    }


    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][]{
                {1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}
        };
        NoOfRestrictedPathFromFirstToLast_1786 nrp = new NoOfRestrictedPathFromFirstToLast_1786();
        System.out.println(nrp.countRestrictedPaths(n, edges));

        int n1 = 7;
        int[][] edges1 = new int[][]{
                {1,3,1},{4,1,2},{7,3,4},{2,5,3},{5,6,1},{6,7,2},{7,5,3},{2,6,4}
        };
        System.out.println(nrp.countRestrictedPaths(n1, edges1));
    }

}
