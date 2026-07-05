package com.dsa.binary_serach_technique;

public class FruitIntoBasket {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n  = fruits.length;
        int cnt = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(baskets[j] >= fruits[i] && !visited[j] ){
                    visited[j] = true;
                    cnt++;
                    break;
                }
            }
        }
        return n - cnt;
    }

}
