package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FlowerPlantingWithNoAdjacent_1042 {

    public int[] gardenNoAdj(int n, int[][] paths) {
        ArrayList<Integer>[] G = new ArrayList[n];
        for(int i = 0; i < n; i++){
            G[i] = new ArrayList<>();
        }
        for(int []edge : paths){
            int u = edge[0]-1;
            int v = edge[1]-1;
            G[u].add(v);
            G[v].add(u);
        }

        int [] color  = new int[n];
        Arrays.fill(color, -1);
        color[0] = 1;

        for(int u = 1; u < n; u++){
            ArrayList<Integer> adjacentToU = G[u];
            HashSet<Integer> usedColor = new HashSet<>();
            for(int v: adjacentToU){
                if(color[v] != -1){
                    usedColor.add(color[v]);
                }
            }
            for(int col = 1; col <= 4; col++){
                if(!usedColor.contains(col)){
                    color[u] = col;
                    break;
                }
            }
        }
        return color;
    }

    public static void main(String[] args) {

    }
}
