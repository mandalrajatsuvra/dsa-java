package com.dsa.graph;

import java.util.HashSet;

public class ShortestPathVisitingAllNodes847 {

    public boolean dfs(int u, int n, int [][]graph, HashSet<Integer> visited){
        visited.add(u);
        if(visited.size() == n){
            return true;
        }
        boolean isAllVisitedNeighbour = true;
        for(int v: graph[u]){
           if(!visited.contains(v)) {
               isAllVisitedNeighbour = false;
               if (dfs(v, n, graph, visited)) return true;
           }
        }
        if(isAllVisitedNeighbour){

        }
        visited.remove(u);
        return false;
    }

    public int shortestPathLength(int[][] graph) {
        HashSet<Integer> visited = new HashSet<>();
        int v = graph.length;
        dfs(0,v,graph,visited);
        System.out.println(visited);
        return 0;
    }

    public static void main(String[] args) {
        int [][]graph = new int[][]{
                {1},
                {0,2,4},
                {1,3,4},
                {2},
                {1,2}
        };
        ShortestPathVisitingAllNodes847 s = new ShortestPathVisitingAllNodes847();
        System.out.println(s.shortestPathLength(graph));
    }
}
