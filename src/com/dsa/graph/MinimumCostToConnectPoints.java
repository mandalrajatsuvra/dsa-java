package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumCostToConnectPoints {
    class DisjointSets{
        int [] parent;
        int [] size;

        public DisjointSets(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
            Arrays.fill(size,1);
        }
        int parent(int u){
            if(u == parent[u]){
                return u;
            }
            return parent[u] = parent(parent[u]);
        }
        boolean connected(int u,int v){
            return parent(u) == parent(v);
        }

        public void union(int u,int v) {
            int pu = parent(u);
            int pv = parent(v);
            if(pu == pv) return;
            if(size[pu] < size[pv]){
                parent[pu] = pv;
                size[pv] += size[pu];
            }else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int [] p1 =  points[i],p2 = points[j];
                int distance = Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
                edges.add(new int[]{i, j,distance});
            }
        }
        Collections.sort(edges, (a, b)-> a[2] - b[2]);
        DisjointSets ds = new DisjointSets(points.length);
        int cost = 0;
        for(int i=0;i<edges.size();i++){
            int [] p = edges.get(i);
            int u  = p[0];
            int v = p[1];
            if(!ds.connected(u,v)){
                ds.union(u,v);
                cost += p[2];
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        MinimumCostToConnectPoints mcp = new MinimumCostToConnectPoints();
        int [][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(mcp.minCostConnectPoints(points));
    }
}
