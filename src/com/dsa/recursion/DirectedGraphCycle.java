package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



enum VertexColor{
    WHITE,
    GRAY,
    BLACK;
}

public class DirectedGraphCycle {


    public boolean hasCycle(int u, List<Integer>[] G, VertexColor[] color){
        if(color[u] == VertexColor.GRAY){
            return true;
        }
        color[u] = VertexColor.GRAY;
        List<Integer> adList = G[u];
        for(int v: adList){
            if(color[v] != VertexColor.BLACK){
                if(hasCycle(v, G, color)) return true;
            }
        }
        color[u] = VertexColor.BLACK;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        List<Integer> [] G = new ArrayList[V];
        for(int i=0; i< V; i++){
            G[i] = new ArrayList<>();
        }
        for(int i=0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            G[u].add(v);
        }
        VertexColor [] color = new VertexColor[V];
        Arrays.fill(color, VertexColor.WHITE);
        for(int i=0; i< V; i++){
            if(hasCycle(i, G, color)) return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
