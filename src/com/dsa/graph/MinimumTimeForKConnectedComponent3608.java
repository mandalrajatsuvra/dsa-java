package com.dsa.graph;

import java.util.Arrays;

public class MinimumTimeForKConnectedComponent3608 {
    public class UnionFindBySize{
        int [] parent;
        int [] size;
        public UnionFindBySize(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
            Arrays.fill(size,1);
        }
        public int find(int u){
            if(u == parent[u]){
                return u;
            }
            return parent[u] = find(parent[u]);
        }
        public boolean connected(int u, int v){
            return find(u) == find(v);
        }
        public void union(int u,int v){
            int pu = find(u);
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
    }

    public int minTime(int n, int[][] edges, int k) {
        if(k > n) return -1;
        Arrays.sort(edges, (a,b)->b[2]-a[2]);
        UnionFindBySize uf = new UnionFindBySize(n);
        int noOfConnectedComponents = n;
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(!uf.connected(u,v)){
                noOfConnectedComponents--;
                uf.union(u,v);
            }
            if(noOfConnectedComponents < k){
                return w;
            }
        }
        return 0;
    }




    public static void main(String[] args) {

    }
}
