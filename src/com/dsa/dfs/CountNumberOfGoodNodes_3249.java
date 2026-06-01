package com.dsa.dfs;

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfGoodNodes_3249 {
    // Correct solutions
    public int dfs(int u, boolean[] visited, ArrayList<Integer>[] G, int []cnt){
        visited[u] = true;
        List<Integer> pr = new ArrayList<>();
        for(int i=0; i<G[u].size(); i++){
            int v = G[u].get(i);
            if(!visited[v]){
               int res = dfs(v, visited, G, cnt);
               pr.add(res);
            }
        }
        boolean allEquals = true;
        for(int x: pr){
            allEquals = allEquals && x==pr.get(0);
        }
        if(allEquals){
            cnt[0]++;
        }

        int totalNodes = 0;
        for(int x: pr){
            totalNodes += x;
        }
        totalNodes +=1;
        return totalNodes;
    }

    public int countGoodNodes(int[][] edges) {
        ArrayList<Integer> [] G =  new ArrayList[edges.length+1];
        for(int i = 0; i < G.length; i++){
            G[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
            int u  = edges[i][0];
            int v = edges[i][1];
            G[u].add(v);
            G[v].add(u);
        }
        boolean[] visited = new boolean[G.length];
        int [] cnt = new int[]{0};
        dfs(0, visited, G, cnt);
        return cnt[0];
    }
    public static void main(String[] args) {
        CountNumberOfGoodNodes_3249 cn = new CountNumberOfGoodNodes_3249();
        int [][] edges = {
                {0,1},
                {0,2},
                {1,3},
                {1,4},
                {2,5},
                {2,6}
        };

        System.out.println(cn.countGoodNodes(edges));
    }
}
