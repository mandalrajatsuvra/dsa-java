package com.dsa.recursion;

import java.util.*;

public class SCC {
    public void dfs(int u, List<Integer> [] G, boolean[] marked, Stack<Integer> stack){
        marked[u] = true;
        for(int v: G[u]){
            if(!marked[v]){
                dfs(v, G, marked, stack);
            }
        }
        stack.push(u);
    }

    public void dfs(int u, ArrayList<ArrayList<Integer>> G, boolean[] marked, TreeSet<Integer> res){
        marked[u] = true;
        res.add(u);
        for(int v: G.get(u)){
            if(!marked[v]){
                dfs(v, G, marked, res);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> findSCC(int V, ArrayList<ArrayList<Integer>> adj) {

        List<Integer> [] RG = new ArrayList[V];
        for(int i=0; i < V; i++){
            RG[i] = new ArrayList<>();
        }
        for(int i=0; i< V; i++){
            ArrayList<Integer> adList = adj.get(i);
            for(int j=0; j< adList.size(); j++){
                RG[adList.get(j)].add(i);
            }
        }

        boolean [] marked = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int u=0; u< V; u++){
            if(!marked[u]){
                dfs(u, RG, marked, stack);
            }
        }

        marked = new boolean[V];
        TreeSet<TreeSet<Integer>> res = new TreeSet<>((a, b)-> a.first()-b.first());
        while (!stack.isEmpty()){
            int u = stack.pop();
            if(!marked[u]){
                TreeSet<Integer> pr= new TreeSet<>();
                dfs(u, adj, marked, pr);
                res.add(pr);
            }
        }

        ArrayList<ArrayList<Integer>> finalRes = new ArrayList<>();
        for(TreeSet<Integer> ts: res){
            finalRes.add(new ArrayList<>(ts));
        }
        return finalRes;
    }

    public static void main(String[] args) {

    }
}
