package com.dsa.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountIslandDSU {
    class DSU{
        int [] parent;
        int [] rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i< n; i++){
                parent[i] = i;
            }
        }
        public int find(int u){
            if(parent[u] == u){
                return parent[u];
            }
            parent[u] = find(parent[u]);
            return parent[u];
        }
        public boolean connected(int u, int v){
            return find(u) == find(v);
        }
        public void union(int u,int v){
            int pu = find(u);
            int pv = find(v);
            if(rank[pv] > rank[pu]){
                parent[pu] = pv;
            }else{
                parent[pv] = pu;
                if(rank[pv] == rank[pu]){
                    rank[pu]+=1;
                }
            }
        }
        public void print(){
            System.out.println(Arrays.toString(parent));
        }
    }

    public int countIslands(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        DSU dsu = new DSU(m*n);
        int[][] dis = {{-1,0}, {1, 0}, {0,1}, {0,-1}};
        for(int i=0; i< m; i++){
            for(int j=0; j < n; j++){
                if(grid[i][j] > 0){
                    for(int d=0; d<4; d++){
                        int x1 = i+ dis[d][0];
                        int y1 = j+ dis[d][1];
                        boolean isValid = x1 >=0 &&  x1 < m && y1 >=0 && y1 < n && grid[x1][y1] > 0;
                        if(isValid) {
                            if (!dsu.connected(n * i + j, n * x1 + y1)) {
                                dsu.union(n * i + j, n * x1 + y1);
                            }
                        }
                    }
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int t=0; t< m*n; t++){
            int i= t/n;
            int j= t%n;
            if(grid[i][j] > 0){
                map.put(dsu.parent[t],  map.getOrDefault(dsu.parent[t], 0) + grid[i][j]);
            }
        }
        int cnt =0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() % k ==0){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int [][] grid = {
                {0,2,1,0,0},
                {0,5,0,0,5},
                {0,0,1,0,0},
                {0,1,4,7,0},
                {0,2,0,0,8}
        };
        int k = 5;
        CountIslandDSU obj = new CountIslandDSU();
        System.out.println(obj.countIslands(grid, k));
    }
}
