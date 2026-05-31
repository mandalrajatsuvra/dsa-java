package com.dsa.dfs;

import java.util.*;

public class FindEdgeInShortestPath_3123 {
    // Correct solutions
    public ArrayList<int[]>[] createGraph(int n, int [][] edges){
        ArrayList<int[]> []G = new ArrayList[n];
        for(int i = 0; i < n; i++){
            G[i] = new ArrayList<>();
        }
        for(int [] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            G[u].add(new int[]{v,w});
            G[v].add(new int[]{u,w});
        }
        return G;
    }

    public void dfs(int u, HashSet<Integer> []G, boolean[] visited, HashMap<String, Integer> edgeMap, boolean [] ans) {
        visited[u] = true;
        for(int v: G[u]){
            if(!visited[v]) {
                String edge = String.valueOf(v) + "->"+ String.valueOf(u);
                if(edgeMap.containsKey(edge)){
                    ans[edgeMap.get(edge)] = true;
                }
                dfs(v, G, visited, edgeMap, ans);
            }
        }
        visited[u] = false;
    }
    public boolean[] findAnswer(int n, int[][] edges) {
        boolean[] ans = new boolean[edges.length];
        ArrayList<int[]> []G = new ArrayList[n];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            G[i] = new ArrayList<>();
        }
        for(int i=0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            G[u].add(new int[]{v,w});
            G[v].add(new int[]{u,w});
            String e1 =  String.valueOf(u) + "->" + String.valueOf(v);
            String e2 = String.valueOf(v)+ "->" + String.valueOf(u);
            map.put(e1, i);
            map.put(e2, i);
        }
        int [] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        minHeap.offer(new int[]{0, 0});
        HashSet<Integer> [] parent = new HashSet[n];
        for(int i = 0; i < n; i++){
            parent[i] = new HashSet<>();
        }
        while (!minHeap.isEmpty()){
            int [] node = minHeap.poll();
            int u = node[0];
            int w =  node[1];

            for(int []t: G[u]){
                int v = t[0];
                int wt =  t[1];
                if(distance[v] > w + wt){
                    distance[v] = w + wt;
                    minHeap.offer(new int[]{v, distance[v]});
                    parent[v] = new HashSet<>();
                    parent[v].add(u);
                }else if(distance[v] == w + wt){
                    minHeap.offer(new int[]{v, distance[v]});
                    parent[v].add(u);
                }
            }
        }
        if(distance[n-1] == Integer.MAX_VALUE){
            return ans;
        }
        //HashSet<String> paths = new HashSet<>();
        boolean[] visited = new boolean[n];
        dfs(n-1, parent, visited, map, ans);
        /*for(int i =0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            String p1 = String.valueOf(u)+"->"+String.valueOf(v);
            String p2 = String.valueOf(v)+"->"+String.valueOf(u);
            if(paths.contains(p1) || paths.contains(p2)){
                ans[i] = true;
            }
        }*/
        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = new int[][]{
                {0,1,4},
                {0,2,1},
                {1,3,2},
                {1,4,3},
                {1,5,1},
                {2,3,1},
                {3,5,3},
                {4,5,2}
        };
        FindEdgeInShortestPath_3123 ob  =  new FindEdgeInShortestPath_3123();
        System.out.println( Arrays.toString(ob.findAnswer(n,edges)));
    }
}
