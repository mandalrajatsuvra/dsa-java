package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NumberOfIslandGFG {

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
        List<Integer> res = new ArrayList<>();
        int [][] dis = {{-1,0}, {1, 0},  {0, -1}, {0, 1}};
        UnionFind uf = new UnionFind(rows* cols);
        int [][] grid = new int [rows][cols];
        int connectedComponents = 0;
        for(int i=0 ; i< operators.length;i++){
            int u =  operators[i][0];
            int v =  operators[i][1];
            HashSet<Integer> parentSet = new HashSet<>();
            for(int d[]: dis){
                int u1 = u + d[0];
                int v1 = v + d[1];
                if(u1 >= 0 && u1  < rows && v1 >= 0 && v1 < cols && grid[u1][v1] == 1){
                    int p2 = cols * u1 + v1;
                    int p1 = cols * u + v;
                    if(!parentSet.contains(uf.find( p2))){
                        uf.union(p1, p2);
                        parentSet.add(uf.find(p2));
                    }

                }
            }
            grid[u][v] = 1;
            connectedComponents -= parentSet.size();
            connectedComponents++;
            res.add(connectedComponents);
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfIslandGFG ob = new NumberOfIslandGFG();
        int n = 4;
        int m = 5;
        int [][] A = {
                {1,1},
                {0,1},
                {3,3},
                {3,4}
        };

        System.out.println(ob.numOfIslands(n, m, A));

        int [][] A2 = {{1 ,3}, {0 ,3}, {0,1}, {1,1}, {1,0}, {1, 2}, {0, 3}, {1,2}};

        int n2=2;
        int m2 = 4;
        System.out.println(ob.numOfIslands(n2, m2, A2));
    }
}
