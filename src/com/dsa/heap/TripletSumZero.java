package com.dsa.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumZero {

  /*  Example 1:
    Input: nums = [-1,0,1,2,-1,-4]

    [-4, -1, -1, 0, 1, 2]

    Output: [[-1,-1,2],[-1,0,1]]
    Example 2:
    Input: nums = []
    Output: []
    Example 3:
    Input: nums = [0]
    Output: []*/


    public static List<List<Integer>> calculate(int [] arr){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0; i< n;){
            int j = i+1;
            int k = n-1;
            while (j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    res.add(temp);
                    int k1 = k;
                    while(k1 >= 0 && arr[k1] == arr[k]){
                        k1--;
                    }
                    k = k1;
                    int j1 = j;
                    while (j1 < arr.length && arr[j1] == arr[j]){
                        j1++;
                    }
                    j = j1;
                }else if(sum > 0){


                    k--;
                }else{
                    j++;
                }
            }
            int i1 = i;
            while (i1 < n &&  arr[i1] == arr[i]){
                i1++;
            }
            i = i1;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4,-1,0,1,2,-1,-4,-1,0,1,2,-1,-4};
        List<List<Integer>> res = calculate(arr);
        System.out.println(res);
    }
}
