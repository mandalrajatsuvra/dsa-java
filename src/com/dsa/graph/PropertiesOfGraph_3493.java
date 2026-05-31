package com.dsa.graph;

import java.util.ArrayList;
import java.util.HashSet;

public class PropertiesOfGraph_3493 {
    // Correct solutions Leet code
    public void dfs(int u, ArrayList<Integer>[] G, boolean [] visited){
        visited[u]=true;
        for(int v:G[u]){
            if(!visited[v]){
                dfs(v,G,visited);
            }
        }
    }
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        ArrayList<Integer>[] G = new ArrayList[n];
        for(int i=0; i<n; i++){
            G[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            HashSet<Integer> ithSet = new HashSet<>();
            for(int x: properties[i]){
                ithSet.add(x);
            }
            for(int j=i+1;j<n;j++){
                int cnt =0;
                HashSet<Integer> ithSet2 = new HashSet<>();
                for(int x: properties[j]){
                    ithSet2.add(x);
                }
                for(int x: ithSet2){
                    if(ithSet.contains(x)){
                        cnt++;
                    }
                }

                if(cnt  >=  k){
                    G[i].add(j);
                    G[j].add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int noOfConnectedComponents = 0;
        for(int u=0; u< n; u++){
            if(!visited[u]){
                noOfConnectedComponents++;
                dfs(u,G,visited);
            }
        }
        return noOfConnectedComponents;
    }

    public static void main(String[] args) {
        int [][] properties = new int[][]{{1,2},{1,1},{3,4},{4,5}, {5,6}, {7,7}};
        int k = 1;
        PropertiesOfGraph_3493 p = new PropertiesOfGraph_3493();
        System.out.println( p.numberOfComponents(properties, k));

        int [][] properties2 = {
                {1,2,3},
                {2,3,4},
                {4,3,5}
        };
        int k2 = 2;
        System.out.println( p.numberOfComponents(properties2, k2));

    }

}
