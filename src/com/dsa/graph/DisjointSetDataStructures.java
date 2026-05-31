package com.dsa.graph;

import java.util.Arrays;

public class DisjointSetDataStructures {


   static public class UnionFind{
        int [] parent;
        int [] rank;
        public UnionFind(int [] parent){
            this.parent = parent;
        }
        public int find(int u){
            if(u==parent[u]){
                return u;
            }
            parent[u] = find(parent[u]);
            System.out.println(parent[u]);
            return parent[u];
        }
        public void print(){
            System.out.println(Arrays.toString(parent));
        }
    }








    public static void main(String[] args) {
        int [] parent =  new int []{0, 0, 1, 2, 3, 4 , 2};
        UnionFind uf = new UnionFind(parent);
        uf.find(6);
        uf.print();



    }
}
