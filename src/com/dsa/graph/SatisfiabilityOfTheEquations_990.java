package com.dsa.graph;

import java.util.Arrays;

public class SatisfiabilityOfTheEquations_990 {
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

    public boolean equationsPossible(String[] equations) {
        UnionFind equalUnionFind = new UnionFind(26);
        for(int i=0;i<equations.length;i++){
            String equation = equations[i];
            int u = equation.charAt(0) - 'a';
            int v = equation.charAt(3) - 'a';
            String operator = equation.substring(1,3);
            if("==".equals(operator)){
                equalUnionFind.union(u,v);
            }
        }

        for(int i=0;i<equations.length;i++){
            String equation = equations[i];
            int u = equation.charAt(0) - 'a';
            int v = equation.charAt(3) - 'a';
            String operator = equation.substring(1,3);
            if("!=".equals(operator)){
                if(equalUnionFind.connected(u,v)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SatisfiabilityOfTheEquations_990 sa =  new SatisfiabilityOfTheEquations_990();

        String[] equations = {
                "a==b","b!=c","c==a"
        };

        System.out.println(sa.equationsPossible(equations));


    }
}
