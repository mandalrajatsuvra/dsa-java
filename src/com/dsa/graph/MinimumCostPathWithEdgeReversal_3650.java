package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostPathWithEdgeReversal_3650 {
    ArrayList<int[]>[] createGraph(int n ,int [][] edges){
        ArrayList<int[]>[]  G = new ArrayList[n];
        for(int i=0; i<n; i++){
            G[i] = new ArrayList<>();
        }
        for(int i=0 ; i< edges.length; i++){
            int u= edges[i][0];
            int v= edges[i][1];
            int w= edges[i][2];
            G[u].add(new int[]{v,w});
            G[v].add(new int[]{u,2*w});
        }
        return G;
    }
    public int minCost(int n, int[][] edges) {
        ArrayList<int[]>[]  G = createGraph(n,edges);
        int [] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)-> a[1]-b[1]);
        minHeap.offer(new int[]{0,0});
        while(!minHeap.isEmpty()){
            int node [] = minHeap.poll();
            int u=  node[0];
            int w= node[1];
            for(int []e: G[u]){
                int v = e[0];
                int wt =  e[1];
                if(distance[v] > w + wt){
                    distance[v] = w + wt;
                    minHeap.offer(new int[]{v,distance[v]});
                }
            }
        }
        return distance[n-1] == Integer.MAX_VALUE ? -1 : distance[n-1];
    }

    public static void main(String[] args) {
        MinimumCostPathWithEdgeReversal_3650  ob = new MinimumCostPathWithEdgeReversal_3650();
        int [][] edges = new int[][]{
                {0,1,3},
                {3,1,1},
                {2,3,4},
                {1,2,3},
        };
        int n = 4;
        System.out.println(ob.minCost(n,edges));

        int [][] edges2 = new int[][]{
                {0,2,1},
                {2,1,1},
                {1,3,1},
                {2,3,3}
        };
        System.out.println(ob.minCost(n,edges2));

    }
}
