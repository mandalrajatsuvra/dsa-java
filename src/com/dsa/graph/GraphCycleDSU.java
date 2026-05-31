package com.dsa.graph;

import java.util.ArrayList;
import java.util.HashSet;

public class GraphCycleDSU {
    public class UnionFindBySize{
        int [] parent;
        int [] size;
        public UnionFindBySize(int V){
            parent = new int[V];
            size = new int[V];
            for(int i = 0; i < V; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int u){
            if(u == parent[u]){
                return u;
            }
            parent[u] = find(parent[u]);
            return parent[u];
        }
        public void union(int u, int v){
            int pu = find(u);
            int pv = find(v);
            if(pu == pv){
                return;
            }
            if(size[pu] < size[pv]){
                parent[pu] = pv;
                size[pv] += size[pu];
            }else{
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
        public boolean connected(int u, int v){
            return find(u) == find(v);
        }
    }

    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        //[[2, 3, 4], [3], [0, 4], [0, 1], [0, 2]]
        UnionFindBySize ufs = new UnionFindBySize(V);
        HashSet<String> visited = new HashSet<>();
        for(int u = 0; u < V; u++){
            for(int v:  adj.get(u)){
                if(!visited.contains(u + "-"+ v)){
                    if(!ufs.connected(u, v)){
                        ufs.union(v, u);
                    }else{
                        return 1;
                    }
                    visited.add(u + "-" +v);
                    visited.add(v + "-" +u);
                }

            }
        }
        return 0;
    }
}
