package com.dsa.binary_serach_technique;

import java.util.Arrays;

public class CoinPilesGFG {
    public int minimumCoins(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int st =0;
        int end = 0;
        for(int i=0; i<n; i++){
            end+= arr[i];
        }

        int res = 0;
        while(st <= end){
            int mid = st+(end-st)/2;
           // int maxDiff = getMaxDiff(arr.clone(), mid);
           /* if(maxDiff <= k){
                res = mid;
                st = mid+1;
            }else{
                end = mid-1;
            }*/

        }
        return res;
    }



    public static void main(String[] args) {

    }
}
