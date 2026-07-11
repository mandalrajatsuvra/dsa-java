package com.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MostProfitAssigningWork {


    /*
    *
    * Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
      Output: 100
      Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get a profit of [20,20,30,30] separately.
    *
    *
    *
    * */



    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0]- a[0]);
        for(int i = 0; i < n; i++){
            maxHeap.add(new int[]{profit[i], difficulty[i]});
        }
        Integer[] arr = Arrays.stream(worker)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            while (!maxHeap.isEmpty() && arr[i] < maxHeap.peek()[1]) {
                maxHeap.poll();
            }
            if(!maxHeap.isEmpty()) {
                res += maxHeap.peek()[0];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] difficulty = {85, 47, 57};
        int[] profit = {24, 66, 99};
        int[] worker = {40, 25, 25};

        System.out.println(new MostProfitAssigningWork().maxProfitAssignment(difficulty, profit, worker));
    }


}
