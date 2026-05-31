package com.dsa.graph;

import java.util.ArrayList;
import java.util.HashSet;

public class MotherVertex {
    public void dfs(int u, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> visited){
        visited.add(u);
        for(int v : adj.get(u)){
            if(!visited.contains(v)){
                dfs(v, adj, visited);
            }
        }
    }
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        for(int u=0;u<V;u++){
            HashSet<Integer> visited = new HashSet<>();
            dfs(u, adj, visited);
            if(visited.size() == V){
                return u;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
