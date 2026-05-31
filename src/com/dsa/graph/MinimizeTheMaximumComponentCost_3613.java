package com.dsa.graph;

import java.util.Arrays;
// Correct solutions
public class MinimizeTheMaximumComponentCost_3613 {
    public class UnionFind{
        int [] parent;
        int [] size;

        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
            Arrays.fill(size,1);
        }
        public int find(int u){
            if(parent[u]==u){
                return u;
            }
            parent[u] = find(parent[u]);
            return parent[u];
        }
        public boolean connected(int u,int v){
            return find(u)==find(v);
        }
        public void union(int u,int v){
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return;
            if(size[pu] > size[pv]){
                parent[pv] = pu;
                size[pu] += size[pv];
            }else{
                parent[pu] = pv;
                size[pv] += size[pu];
            }
        }
    }

    public int minCost(int n, int[][] edges, int k) {
        UnionFind uf = new UnionFind(n);
        Arrays.sort(edges, (a, b)-> a[2] - b[2]);
        int noOfComponents = n;
        int cost = 0;
        if(noOfComponents <= k){
            return cost;
        }
        for(int []edge: edges){
            int u =  edge[0];
            int v =  edge[1];
            int w =  edge[2];
            cost = Math.max(cost, w);
            if(!uf.connected(u,v)){
                uf.union(u,v);
                noOfComponents--;
            }
            if(noOfComponents <= k){
                return cost;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
