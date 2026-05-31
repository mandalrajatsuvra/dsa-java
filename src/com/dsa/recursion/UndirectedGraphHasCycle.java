package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


enum Color{
    WHITE,
    GRAY,
    BLACK;
}

public class UndirectedGraphHasCycle {

    public boolean hasCycle(int prev, int u, List<Integer> []G, Color[] color){
        if(color[u] == Color.GRAY){
            return true;
        }
        color[u] = Color.GRAY;
        for(int v: G[u]){
            if(v != prev && color[v] != Color.BLACK) {
                if(hasCycle(u, v, G, color)) return true;
            }
        }
        color[u] = Color.BLACK;
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        List<Integer>[] G = new ArrayList[V];
        for(int i=0; i< V; i++){
            G[i] = new ArrayList<>();
        }
        for(int i=0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            G[u].add(v);
            G[v].add(u);
        }
        Color [] color = new Color[V];
        Arrays.fill(color, Color.WHITE);
        return hasCycle(-1, 0, G, color);
    }

    public static void main(String[] args) {
        int [][] edges = {{0,1 }, {0, 2}, {1, 2}, {2, 3}};
        UndirectedGraphHasCycle ob = new UndirectedGraphHasCycle();
        System.out.println(ob.isCycle(4, edges));
        int [][] edges2 = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(ob.isCycle(4, edges2));
    }
}
