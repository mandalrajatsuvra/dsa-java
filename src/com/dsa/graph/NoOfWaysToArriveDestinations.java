package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NoOfWaysToArriveDestinations {

    public ArrayList<ArrayList<int[]>> createGraph(int n, int [][] edges) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});

        }
        return graph;
    }
    public int countPaths(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> graph = createGraph(V, edges);
        int [] distance =  new int[V];
        Arrays.fill(distance, (int)1e9);
        distance[0] = 0;
        int [] ways = new int[V];
        ways[0] = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[1]-b[1]);
        pq.offer(new int[]{0,0});

        while(!pq.isEmpty()){
            int []node = pq.poll();
            int u = node[0];

            for(int [] edge: graph.get(u)){
                int v = edge[0];
                int w = edge[1];
                if(distance[v] > distance[u] + w){
                    distance[v] = node[1] + w;
                    ways[v] = ways[u];
                    pq.offer(new int[]{v,distance[v]});
                }else if(distance[v] == node[1] + w){
                    ways[v] += ways[u];
                }
            }

        }
        return ways[V-1];
    }
    public static void main(String[] args) {

    }
}
