package com.dsa.graph;

import java.util.Arrays;

public class PathExistenceQueries {
    public class UnionFind{
        int [] parent;
        int [] rank;
        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=0;
            }
        }
        public boolean connected(int u,int v){
            return find(u)==find(v);
        }
        public int find(int u){
            if(u==parent[u]){
                return u;
            }
            parent[u] = find(parent[u]);
            return parent[u];
        }
        public void union(int u,int v){
            int pu = find(u);
            int pv = find(v);
            if(pu == pv){
                return;
            }
            if(rank[pu] > rank[pv]){
                parent[pv]= pu;
            }else{
                parent[pu]= pv;
                if(rank[pu]==rank[pv]){
                    rank[pv]+=1;
                }
            }
        }

    }


    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean [] res =  new boolean[queries.length];
        UnionFind uf = new UnionFind(n);
        for(int i=1; i< n; i++){
            if(Math.abs(nums[i]-nums[i-1]) <= maxDiff){
                if(!uf.connected(i,i-1)){
                    uf.union(i,i-1);
                }
            }
        }
        for(int i=0; i< queries.length; i++){
            int u  = queries[i][0];
            int v = queries[i][1];
            if(uf.connected(u,v)){
                res[i] = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PathExistenceQueries p = new PathExistenceQueries();
        int n = 4;
        int nums [] = {2,5,6,8};
        int maxDiff = 2;
        int[][] queries = {
                {0,1},
                {0,2},
                {1,3},
                {2,3}
        };

        System.out.println(Arrays.toString(p.pathExistenceQueries(n, nums, maxDiff, queries)));

    }
}
