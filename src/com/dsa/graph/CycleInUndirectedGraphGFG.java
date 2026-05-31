package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class CycleInUndirectedGraphGFG {
    public enum Color {
        WHITE,
        GRAY,
        BLACK
    }

    public boolean dfs(int u, int p, ArrayList<ArrayList<Integer>> G, Color[] color) {
        color[u] = Color.GRAY;

        for (int v : G.get(u)) {
            if(color[v] == Color.GRAY && v != p ) {
                return true;
            }
            if(color[v] == Color.WHITE) {
                if(dfs(v,u, G, color)) {
                    return true;
                }
            }
        }
        color[u] = Color.BLACK;
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            G.add(new ArrayList<>());
        }
        for(int [] edge: edges){
            int u  = edge[0];
            int v = edge[1];
            G.get(u).add(v);
            G.get(v).add(u);
        }
        Color[] colors = new Color[V];
        Arrays.fill(colors, Color.WHITE);
        for(int u=0; u< V; u++){
            if(dfs(u,V,G,colors)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
