package com.dsa.recursion.permutations;

public class LargestNumberAfterKSwap {

    private String res = "";

    public void solve(char[] arr, int k){
        if(k==0) return;

        for(int i=0; i< arr.length; i++){
            for(int j=i+1; j< arr.length; j++){
                if(arr[j] > arr[i]){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                String s = new String(arr);
                if(s.compareTo(res) > 0){
                    res = s;
                }
                solve(arr, k-1);
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                }
            }
        }
    }
    public String findMaximumNum(String s, int k) {
        res=s;
        solve(s.toCharArray(), k);
        return res;
    }
    public static void main(String[] args) {
        LargestNumberAfterKSwap largestNumberAfterKSwap = new LargestNumberAfterKSwap();
        String res = largestNumberAfterKSwap.findMaximumNum("1234567", 4);
        System.out.println(res);

        String res3 = largestNumberAfterKSwap.findMaximumNum("4577", 2);
        System.out.println(res3);
    }
}
