package com.dsa.graph;

import java.util.Arrays;

public class BridgeEdgeInAUndirectedGraphGFG {
    public class UnionFind {
        int [] parent;
        int [] size;

        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++) {
                parent[i] = i;
            }
            Arrays.fill(size,1);
        }
        public int find(int u){
            if(u == parent[u]){
                return u;
            }
            parent[u] = find(parent[u]);
            return parent[u];
        }
        public void union(int u, int v){
            int pu =  find(u);
            int pv = find(v);
            if(pu == pv) return;
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

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        UnionFind uf = new UnionFind(V);
        for(int[] edge: edges){
            int u =  edge[0];
            int v =  edge[1];
            if((u == c && v == d) || (u == d && v == c) )continue;
            if(!uf.connected(u, v)){
                uf.union(v, u);
            }
        }
        return !uf.connected(c, d);
    }

    public static void main(String[] args) {

    }
}
