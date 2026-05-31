package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees_310 {
    // Correct answer but TLE
    public ArrayList<Integer>[]  createGraph(int n, int [][] edges){
        ArrayList<Integer>[]  G = new ArrayList[n];
        for(int i=0; i<n; i++){
            G[i] = new ArrayList<>();
        }
        for(int [] edge: edges){
            int u = edge[0];
            int v = edge[1];
            G[u].add(v);
            G[v].add(u);
        }
        return G;
    }

    public int bfs(int u, ArrayList<Integer>[]  G, int n){
        boolean[] visited = new boolean[n];
        visited[u] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{u, 0});
        int maxHeight = 0;
        while(!queue.isEmpty()){
            int [] node = queue.poll();
            maxHeight = Math.max(maxHeight, node[1]);
            for(int v: G[node[0]]){
                if(!visited[v]){
                    visited[v] = true;
                    queue.offer(new int[]{v, node[1] + 1});
                }
            }
        }
        return maxHeight;
    }
    // Correct Solution without TLE
    public List<Integer> findMinHeightTrees2(int n, int[][] edges){
        List<Integer>[]  G = new ArrayList[n];
        for(int i=0; i<n; i++){
            G[i] = new ArrayList<>();
        }
        int []degree = new int[n];
        for(int [] edge: edges){
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
            G[u].add(v);
            G[v].add(u);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int u=0; u< n ; u++){
            if(degree[u] == 1){
                queue.add(u);
            }
        }
        List<Integer> res = new ArrayList<>();

        while(n > 2){
            int size = queue.size();
            n -=  size;
            for(int i=0; i<size; i++){
                int u = queue.poll();
                for(int v: G[u]){
                    if(--degree[v] == 1){
                        queue.add(v);
                    }
                }
            }
        }
        res.addAll(queue);
        return res;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer>[]  G = createGraph(n, edges);
        List<Integer> res = new ArrayList<>();
        int minHeight = Integer.MAX_VALUE;
        for(int u = 0; u < n; u++){
            int height = bfs(u, G, n);
            if(height < minHeight){
                res = new ArrayList<>();
                res.add(u);
                minHeight = height;
            }else if(height == minHeight){
                res.add(u);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumHeightTrees_310 ob = new MinimumHeightTrees_310();
        int n1 = 4;
        int[][] edges1 = new int[][]{
                {1,0},
                {1,2},
                {1,3}
        };
        System.out.println(ob.findMinHeightTrees(n1, edges1));

        int n2 = 6;

        int[][] edges2 = new int[][]{
                {3,0},
                {3,1},
                {3,2},
                {3,4},
                {5,4},
        };
        System.out.println(ob.findMinHeightTrees(n2, edges2));
    }
}
