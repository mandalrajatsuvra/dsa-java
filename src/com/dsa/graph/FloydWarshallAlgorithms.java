package com.dsa.graph;

import java.util.Arrays;

public class FloydWarshallAlgorithms {

    public void floydWarshall(int[][] dist) {
        int n =  dist.length;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] == (int)1e8 || dist[k][j] == (int)1e8){
                        continue;
                    }
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int [][] dist = {
                {0, 4, (int)1e8, 5, 10},
                {(int)1e8, 0, 1, (int)1e8, 6},
                {2, (int)1e8, 0, 3, (int)1e8},
                {(int)1e8, (int)1e8, 1, 0, 2},
                {1, (int)1e8, (int)1e8, 4, 0}
        };
        FloydWarshallAlgorithms fw = new FloydWarshallAlgorithms();
        fw.floydWarshall(dist);
        System.out.println(Arrays.deepToString(dist));
    }
}
