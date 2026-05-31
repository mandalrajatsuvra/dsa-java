package com.dsa.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCycleInGraph_2360 {

    public enum Color{
        NEW,
        ACTIVE,
        BLACK
    }
    public void dfs(int u, int p, ArrayList<Integer> [] G,  Color[] colors, int [] parent, int []maxLength){
        colors[u] = Color.ACTIVE;
        parent[u] = p;
        for(int v : G[u]){
            if(colors[v] == Color.NEW){
                dfs(v, u, G,colors, parent, maxLength);
            }else if(colors[v] == Color.ACTIVE){
                int cnt = 1;
                int w = u;
                while(w != v){
                    w = parent[w];
                    cnt++;
                }
                maxLength[0] = Math.max(maxLength[0], cnt);
            }
        }
        parent[u] = -1;
        colors[u] = Color.BLACK;
    }


    public ArrayList<Integer>[] createGraph(int n, int [] edges){
        ArrayList<Integer>[]  G = new ArrayList[n];
        for(int i=0;i<n;i++){
            G[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            if(edges[i] != -1){
                G[i].add(edges[i]);
            }
        }
        return G;
    }
    public int longestCycle(int[] edges) {
        Color[] colors = new Color[edges.length];
        ArrayList<Integer> [] G = createGraph(edges.length, edges);
        Arrays.fill(colors, Color.NEW);
        int [] maxLength = new int[]{-1};
        int [] parent = new int[edges.length];
        Arrays.fill(parent, -1);
        for(int i=0; i< edges.length; i++){
            if(colors[edges[i]] == Color.NEW){
                dfs(i, -1, G, colors, parent, maxLength);
            }
        }
        return maxLength[0];
    }

    public static void main(String[] args) {
        int [] edges = {3,3,4,2,3};
        LongestCycleInGraph_2360 ob = new LongestCycleInGraph_2360();
        System.out.println(ob.longestCycle(edges));
    }
}
