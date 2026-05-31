package com.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class RemoveMethodFromProject_3310 {

    public ArrayList<Integer>[] createGraph(int n, int [][] invocations){
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i< invocations.length; i++){
            int u =  invocations[i][0];
            int v = invocations[i][1];
            graph[u].add(v);
        }
        return graph;
    }
    public void dfs(int u, ArrayList<Integer>[] graph, boolean []visited){
       visited[u] = true;
       for(int v: graph[u]){
           if(!visited[v]){
               dfs(v, graph, visited);
           }
       }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> res = new ArrayList<>();
        ArrayList<Integer>[] graph = createGraph(n, invocations);
        boolean[] visited = new boolean[n];
        dfs(k, graph, visited);
        boolean suspicious = true;

        for(int u=0; u<n; u++){
             if(!visited[u]){
                 for(int v: graph[u]){
                     if(visited[v]){
                         suspicious = false;
                         break;
                     }
                 }
             }
        }

        if(suspicious){
            for(int u=0; u<n; u++){
                if(!visited[u]){
                    res.add(u);
                }
            }
        }else{
            for(int u=0; u<n; u++){
                res.add(u);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
