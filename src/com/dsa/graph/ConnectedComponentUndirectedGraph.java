package com.dsa.graph;

import java.util.ArrayList;

public class ConnectedComponentUndirectedGraph {

    public void dfs(int u, ArrayList<ArrayList<Integer>> G, boolean[] visited, ArrayList<Integer> res) {
        visited[u] = true;
        res.add(u);
        ArrayList<Integer> adj = G.get(u);
        for(int v: adj){
            if(!visited[v]){
                dfs(v, G, visited, res);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
      boolean[] visited = new boolean[V];
      ArrayList<ArrayList<Integer>> components = new ArrayList<>();
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for (int u = 0; u < V; u++) {
          adj.add(new ArrayList<>());
      }
      for(int edge[] : edges){
          adj.get(edge[0]).add(edge[1]);
          adj.get(edge[1]).add(edge[0]);
      }
      for(int u = 0; u < V; u++){
          if(!visited[u]){
              ArrayList<Integer> component = new ArrayList<>();
              dfs(u, adj, visited, component);
              components.add(component);
          }
      }
      return components;
    }

    public static void main(String[] args) {
        ConnectedComponentUndirectedGraph ccu = new ConnectedComponentUndirectedGraph();
        int [][] edges = new int[][]{
                {7, 0},
                {5, 4},
                {1, 6},
                {0, 1}
        };
        System.out.println(ccu.getComponents(8, edges));
    }
}
