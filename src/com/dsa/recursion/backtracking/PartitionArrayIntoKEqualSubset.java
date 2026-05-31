package com.dsa.recursion.backtracking;

public class PartitionArrayIntoKEqualSubset {

    public boolean solve(int [] arr, boolean[] visited, int sum, int target, int k){
        if(k == 1) return true;
        if(sum > target) return false;
        if(sum == target){
            return solve(arr, visited, sum, target, k-1);
        }
        for(int i=0; i< arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(solve(arr, visited, sum+arr[i], target, k)) return true;
                visited[i] = false;
            }
        }

        return  false;
    }

    public boolean isKPartitionPossible(int[] arr, int k) {
        int sum = 0;
        for(int i=0; i< arr.length; i++){
            sum += arr[i];
        }
        if(sum % k != 0) return false;
        boolean[] visited = new boolean[arr.length];
        return solve(arr,visited, 0, sum/k, k);
    }
    public static void main(String[] args) {
        int [] arr = {4, 4, 6, 2, 3 ,8 ,10 ,2 ,10 ,7};
        int [] arr1 = {2, 1, 5, 5, 6};
        int [] arr2 = {4, 3 ,2, 3, 5, 2, 1};
        PartitionArrayIntoKEqualSubset pa = new PartitionArrayIntoKEqualSubset();
        System.out.println(pa.isKPartitionPossible(arr1, 4));
    }
}
