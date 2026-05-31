package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DigitOperationToMakeTwoIntegerEqual_3377 {
    // Correct solutions
    public int minOperations(int n, int m) {
        if(isPrime(n) || isPrime(m)) return -1;
        int digits = String.valueOf(n).length();
        int [] cost = new int[(int)Math.pow(10, digits)];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[n] = n;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{n, n});

        while(!minHeap.isEmpty()){
            int [] node = minHeap.poll();
            int u = node[0];
            int c = node[1];
            if(c > cost[u]){
                continue;
            }
            for(int v: neighbour(u)){
                if(cost[v] > c + v){
                    cost[v] = c + v;
                    minHeap.offer(new int[]{v, cost[v]});
                }
            }
        }
        return cost[m] == Integer.MAX_VALUE ? -1 : cost[m];
    }

    private boolean isPrime(int n){
        if(n <= 1) return false;
        for(int div = 2; div *div <= n ; div++){
            if(n % div == 0) return false;
        }
        return true;
    }

    private List<Integer>  neighbour(int u) {
        List<Integer> neighbours = new ArrayList<>();
        String uStr = String.valueOf(u);
        for(int i = 0; i < uStr.length(); i++){
            char[] uArr = uStr.toCharArray();
            if(uArr[i] != '9'){
                uArr[i] += 1;
                String s = new String(uArr);
                int sVal = Integer.parseInt(s);
                if(!isPrime(sVal)){
                    neighbours.add(sVal);
                }
            }
        }

        for(int i = 0; i < uStr.length(); i++){
            char [] uArr = uStr.toCharArray();
            if(uArr[i] != '0'){
                uArr[i] -= 1;
                String s = new String(uArr);
                int sVal = Integer.parseInt(s);
                if(!isPrime(sVal)){
                    neighbours.add(sVal);
                }
            }
        }
        return neighbours;
    }

    public static void main(String[] args) {
        DigitOperationToMakeTwoIntegerEqual_3377 dig = new DigitOperationToMakeTwoIntegerEqual_3377();
        System.out.println(dig.minOperations(10, 12));
        System.out.println(dig.minOperations(4, 8));
        System.out.println(dig.minOperations(6, 2));
    }
}
