package com.dsa.graph;

import java.util.*;

public class DijkstraShortestPath {

    public ArrayList<ArrayList<int[]>> createGraph(int n, int m, int [][]edges){
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m ; i++){
            int u = edges[i][0]-1;
            int v = edges[i][1]-1;
            int w = edges[i][2];
            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});

        }
        return graph;
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<int[]>> graph = createGraph(n, m, edges);
        int [] distances = new int [n];
        int [] parent = new int [n];
        Arrays.fill(parent, -1);
        Arrays.fill(distances, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{0,0});
        distances[0] = 0;
        while(!pq.isEmpty()){
            int node[] = pq.poll();
            int u = node[0];

            for(int []edge  : graph.get(u)){
                int v = edge[0];
                int w = edge[1];
                if(distances[v] > distances[u] + w){
                    distances[v] = distances[u] + w;
                    parent[v] = u;
                    pq.offer(new int[]{v,w});
                }
            }
        }

        if(distances[n-1] == Integer.MAX_VALUE){
            res.add(-1);
        }else {
            res.add(distances[n-1]);
            List<Integer> path = new ArrayList<>();
            int i = n - 1;
            do {
                path.add(i + 1);
                i = parent[i];
            } while (i != -1);
            Collections.reverse(path);
            res.addAll(path);
        }
        return res;
    }

    public static void main(String[] args) {
        DijkstraShortestPath ds = new DijkstraShortestPath();
        int n = 5, m=6;
        int [][] edges = new int[][]{
                {1, 2, 2},
                {2, 5, 5},
                {2, 3, 4},
                {1, 4, 1},
                {4, 3, 3},
                {3, 5, 1}
        };

        System.out.println(ds.shortestPath(n, m, edges));
        int n1 = 2, m1 = 1;
        int [][] edges1 = new int[][]{
                {1, 2, 2},
        };
        System.out.println(ds.shortestPath(n1, m1, edges1));

        int n3 = 2 , m3 = 0;
        int [][] edges2 = new int[][]{};
        System.out.println(ds.shortestPath(n3, m3, edges2));
    }
}
