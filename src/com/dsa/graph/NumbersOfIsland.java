package com.dsa.graph;

import java.util.*;
// solution is correct
public class NumbersOfIsland {

    public class UnionFind{
        int [] parent;
        int [] size;
        public UnionFind(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
            size = new int[n];
            Arrays.fill(size,1);
        }
        public int find(int u){
            if(parent[u] == u){
                return u;
            }
            parent[u] = find(parent[u]);
            return parent[u];
        }

        public void union(int u,int v){
            int pu  = find(u);
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
        public boolean connected(int u,int v){
            return find(u) == find(v);
        }
    }


    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        List<Integer> result = new ArrayList<>();
        int [][] grid = new int [rows][cols];
        if(operators.length == 0){
            return result;
        }
        int cnt = 0;
        int [][] dis = {{-1,0}, {1, 0},  {0, -1}, {0, 1}};
        UnionFind uf = new UnionFind(rows * cols);
        for (int i = 0; i < operators.length; i++) {
            int u =  operators[i][0];
            int v = operators[i][1];
            if(grid[u][v] == 1){
                result.add(cnt);
                continue;
            }
            Set<Integer> parentSet = new HashSet<>();
            for (int [] ds : dis){
                int u1 = u + ds[0];
                int v1 = v + ds[1];
                boolean isValidMove = u1 >= 0 && u1  < rows && v1 >= 0 && v1 < cols && grid[u1][v1] == 1;
                if(isValidMove){
                    int existingSet = cols*u1 + v1;
                    int newSet = cols*u + v;
                    if(!uf.connected(newSet, existingSet)){
                        parentSet.add(uf.find(existingSet));
                        uf.union(newSet, existingSet);
                    }

                }
            }
            cnt -= parentSet.size();
            cnt++;
            grid[u][v] = 1;
            result.add(cnt);
        }

        return  result;
    }

    public static void main(String[] args) {
        int [][] A = {{1,1},{0,1},{3,3},{3,4}};
        int n=4;
        int m =5;
        NumbersOfIsland ni = new NumbersOfIsland();
        System.out.println(ni.numOfIslands(n,m,A));

        int [][] A2 = {{1 ,3}, {0 ,3}, {0,1}, {1,1}, {1,0}, {1, 2}, {0, 3}, {1,2}};

        int n2=2;
        int m2 = 4;
        System.out.println(ni.numOfIslands(n2,m2,A2));

        int [][] A3 = {{0,1}, {0,1}, {0, 1}, {0,0}, {0,1}, {0,0},{0,1}, {0,1}, {0,0}, {0,0}};
        int n3=1;
        int m3=2;
        System.out.println(ni.numOfIslands(n3,m3,A3));

    }
}
