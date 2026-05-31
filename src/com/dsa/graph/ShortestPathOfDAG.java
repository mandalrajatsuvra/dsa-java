package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathOfDAG {

    ArrayList<ArrayList<int []>> createGraph(int V, int E, int [][] edges){
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < E; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            graph.get(u).add(new int[]{v,w});
        }
        return graph;

    }

    public void topologicalSort(int u, ArrayList<ArrayList<int []>> graph, Stack<Integer> stack, boolean [] visited){
        visited[u] = true;
        ArrayList<int []> list = graph.get(u);
        for(int i = 0; i < list.size(); i++){
            int v  = list.get(i)[0];
            if(!visited[v]){
                topologicalSort(v, graph, stack, visited);
            }
        }
        stack.push(u);
    }


    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<int[]>> graph = createGraph(V, E, edges);
        boolean [] visited = new boolean [V];
        Stack<Integer> stack = new Stack<>();
        topologicalSort(0, graph, stack, visited);
        int [] dist = new int[V];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        while(!stack.isEmpty()){
            int u = stack.pop();
            ArrayList<int[]> list = graph.get(u);

            for(int i = 0; i < list.size(); i++){
                int v = list.get(i)[0];
                int w = list.get(i)[1];
                if(dist[u] == -1){
                    continue;
                }
                if(dist[v] == -1){
                    dist[v] = dist[u] + w;
                }else if(dist[v] > dist[u] + w){
                    dist[v] = dist[u] + w;
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        ShortestPathOfDAG sp = new ShortestPathOfDAG();
        int V = 6;
        int E = 7;
        int [][]edges = {
                {0,1,2},
                {0,4,1},
                {4,5,4},
                {4,2,2},
                {1,2,3},
                {2,3,6},
                {5,3,1}
        };

        System.out.println(Arrays.toString(sp.shortestPath(V, E, edges)));

    }
}
