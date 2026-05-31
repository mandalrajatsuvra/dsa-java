package com.dsa.graph;

import java.util.*;

public class MostProfitablePath_2467 {

    // Correct Solutions
    public ArrayList<Integer>[] createGraph(int [][] edges, int n){
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }

    public boolean dfs(int u, int d, int time, ArrayList<Integer>[] G, boolean [] visited, Map<Integer, Integer> nodeTimeMap){
        visited[u] = true;
        nodeTimeMap.put(u, time);
        if(u == d) return true;
        for(int v: G[u]){
            if(!visited[v]){
                if(dfs(v, d, time + 1, G, visited, nodeTimeMap)) return true;
            }
        }
        nodeTimeMap.remove(u);
        visited[u] = false;
        return false;
    }


    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length+1;
        ArrayList<Integer>[] G = createGraph(edges, n);
        boolean[] visited = new boolean[n];
        Map<Integer, Integer> nodeTimeMap = new HashMap<Integer, Integer>();
        dfs(bob, 0, 0, G, visited, nodeTimeMap);
        Arrays.fill(visited, false);
        Queue<int[]> queue = new LinkedList<>();
        visited[0] = true;
        queue.offer(new int[] {0, 0, 0});
        int maxProfit = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int [] cur = queue.poll();
            int u = cur[0];
            int timeOfAlice = cur[1];
            int amt  = cur[2];

            if(nodeTimeMap.containsKey(u)){
                int timeOfBob = nodeTimeMap.get(u);
                if(timeOfBob == timeOfAlice){
                    amt += amount[u]/2;
                }else if(timeOfBob < timeOfAlice){
                    amt+=0;
                }else{
                    amt+=amount[u];
                }
            }else{
                amt += amount[u];
            }

            if(isTerminalNode(u, G, visited)){
                maxProfit = Math.max(maxProfit, amt);
            }
            for(int v: G[u]){
                if(!visited[v]){
                    visited[v] = true;
                    queue.offer(new int[] {v, timeOfAlice+1, amt});
                }
            }
        }
        return maxProfit;
    }

    private boolean isTerminalNode(int u, ArrayList<Integer>[] g, boolean[] visited) {
        for(int v: g[u]){
            if(!visited[v]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MostProfitablePath_2467 mp = new MostProfitablePath_2467();
        int[][] edges = new int[][]{
                {0,1},
                {1,2},
                {1,3},
                {3,4}
        };
        int bob = 3;
        int [] amount = new int[]{-2,4,2,-4,6};
        System.out.println(mp.mostProfitablePath(edges, bob, amount));

        int [][] edges2 = new int[][]{
                {0,1}
        };
        bob = 1;
        amount = new int[]{-7280,2350};

        System.out.println(mp.mostProfitablePath(edges2, bob, amount));
    }
}
