package com.dsa.dfs;

import java.util.ArrayList;

public class DirectedGraphCycle {

    // correct Algorithm for Graph
    public int dfs(int u, ArrayList<ArrayList<Integer>> G, int clock, int []pre, int[]post, boolean[] visited){
        visited[u] = true;
        clock ++;
        pre[u] = clock;
        for(int v: G.get(u)){
            if(!visited[v]){
               clock = dfs(v,G,clock,pre,post,visited);
            }
        }
        clock++;
        post[u] = clock;
        return clock;
    }
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        for(int i=0; i<V; i++){
            G.add(new ArrayList<>());
        }
        for(int edge[]: edges){
            int u =  edge[0];
            int v = edge[1];
            G.get(u).add(v);
        }
        int [] pre = new int[V];
        int [] post  = new int[V];
        boolean[] visited = new boolean[V];
        int clock = 0;
        for(int i=0; i<V; i++){
            if(!visited[i]){
               clock = dfs(i,G,clock,pre,post,visited);
            }
        }
        for(int []edge: edges){
            int u =  edge[0];
            int v = edge[1];
            if(post[u] < post[v]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
