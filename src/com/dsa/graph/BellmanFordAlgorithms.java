package com.dsa.graph;

import java.util.Arrays;

public class BellmanFordAlgorithms {


    public int[] bellmanFord(int V, int[][] edges, int src) {
        int [] distance = new int [V];
        Arrays.fill(distance, (int)1e8);
        distance[src] = 0;
        for(int i=0; i<V-1; i++){
            for(int j=0; j<edges.length; j++){
                int u =  edges[j][0];
                int v =  edges[j][1];
                int w = edges[j][2];
                if(distance[u] == (int)1e8){
                    continue;
                }
                if(distance[v] > distance[u] + w){
                    distance[v] = distance[u] + w;
                }
            }
        }

        for(int i=0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            if(distance[u] == (int)1e8){
                continue;
            }
            if(distance[v] > distance[u] + w ) {
                return new int[]{-1};
            }
        }
        return distance;
    }

    public static void main(String[] args) {

    }
}
