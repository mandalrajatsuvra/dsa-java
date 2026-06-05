package com.dsa.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTimeToCollectAllApples_1443 {

    // Correct solutions

    public static class Pair{
        boolean hasApple;
        int time;
        public Pair(boolean hasApple, int time){
            this.hasApple = hasApple;
            this.time = time;
        }
    }

    public Pair dfs(int u, ArrayList<Integer>[] G, boolean[] visited, List<Boolean> hasApple){

        visited[u] = true;

        List<Pair> pairs = new ArrayList<>();

        for(int v: G[u]){
            if(!visited[v]){
                Pair p = dfs(v, G, visited, hasApple);
                pairs.add(p);
            }
        }
        int time = 0;
        boolean rootHasAppleToTransfer = hasApple.get(u);
        for(Pair p: pairs){
            rootHasAppleToTransfer = rootHasAppleToTransfer || p.hasApple;
            time += p.time;
        }
        if(rootHasAppleToTransfer && u !=0){
            time += 2;
        }
        return new Pair(rootHasAppleToTransfer, time);
    }


    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer> [] G = new ArrayList[n];
        for(int i = 0; i < G.length; i++){
            G[i] = new ArrayList<>();
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            G[u].add(v);
            G[v].add(u);
        }

        boolean[] visited = new boolean[n];
        return dfs(0, G, visited, hasApple).time;
    }


    public static void main(String[] args) {
        MinimumTimeToCollectAllApples_1443 m = new MinimumTimeToCollectAllApples_1443();
        int [][] edges = new int[][]{
                {0,1},
                {0,2},
                {1,4},
                {1,5},
                {2,3},
                {2,6}
        };
        List<Boolean> hasApple = Arrays.asList(false,false,true,false,true,true,false);
        System.out.println(m.minTime(7, edges, hasApple));


        int[][] edges1 = {
                {0, 1},
                {0, 2},
                {1, 4},
                {1, 5},
                {2, 3},
                {2, 6}
        };
        List<Boolean> hasApple1 = Arrays.asList(false,false,true,false,false,true,false);
        System.out.println(m.minTime(7, edges1, hasApple1));
    }

}
