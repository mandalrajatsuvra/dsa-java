package com.dsa.graph;

import java.util.*;

public class BipartiteGraph {


    public boolean bfs(int u, List<Integer>[] G, int [] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        color[u] = 0;
        while (!queue.isEmpty()){
            int v = queue.poll();
            for(int w: G[v]){
                if(color[w] == -1){
                    color[w] = 1- color[v];
                    queue.offer(w);
                }else if(color[w] == color[v]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int V, int[][] edges) {
        int [] color = new int[V];
        Arrays.fill(color, -1);
        List<Integer> [] G = new ArrayList[V];
        for(int i=0; i< V; i++){
            G[i] = new ArrayList<>();
        }
        for(int i=0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            G[u].add(v);
            G[v].add(u);
        }
        for(int u=0; u< V; u++){
            if(!bfs(u, G, color)) return false;
        }
        return true;
    }

    public static void main(String[] args) {



    }
}
