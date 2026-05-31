package com.dsa.graph;

import java.util.*;

public class DijkstraAlgorithms {

    class Edge{
        public int v;
        public int w;
        public Edge(int v,int w){
            this.v=v;
            this.w=w;
        }
    }


    public ArrayList<ArrayList<Edge>> graph(int V, int [][] edges ){
        ArrayList<ArrayList<Edge>> g = new ArrayList<ArrayList<Edge>>();
        for(int i=0;i<V;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            g.get(u).add(new Edge(v,w));
            g.get(v).add(new Edge(u,w));
        }

        return g;
    }


    public int[] dijkstra(int V, int[][] edges, int src) {

        ArrayList<ArrayList<Edge>> g = graph(V, edges);
        int [] distance = new int [V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src]=0;
        Queue<Integer> queue  = new LinkedList<>();
        queue.offer(src);

        while(!queue.isEmpty()){
            int  u =  queue.poll();
            List<Edge>  adjList = g.get(u);
            for(Edge e :  adjList ){
                if(distance[u] + e.w < distance[e.v]){
                    distance[e.v] = distance[u] + e.w;
                    queue.offer(e.v);
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) {
        int V = 3;
        int[][] edges = new int[][]{
                {0, 1, 1},
                {1, 2, 3},
                {0, 2, 6}
        };
        int src = 2;
        DijkstraAlgorithms d = new DijkstraAlgorithms();
        System.out.println(Arrays.toString(d.dijkstra(V,edges,src)));
    }
}
