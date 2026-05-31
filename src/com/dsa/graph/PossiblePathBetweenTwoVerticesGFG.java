package com.dsa.graph;

import java.util.ArrayList;

public class PossiblePathBetweenTwoVerticesGFG {

    // Correct answer
    public int dfs(int s, int d, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        if (s == d) {
            return 1;
        }
        visited[s] = true;
        int totalPath =0;
        for(int v: adj.get(s)) {
            if(!visited[v]) {
                totalPath += dfs(v, d, adj, visited);
            }
        }
        visited[s] = false;
        return totalPath;
    }

    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
                          int destination) {
        boolean[] visited = new boolean[V];
        return dfs(source, destination, adj, visited);
    }
    public static void main(String[] args) {

    }
}
