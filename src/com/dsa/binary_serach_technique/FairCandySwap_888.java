package com.dsa.binary_serach_technique;

import java.util.Arrays;

public class FairCandySwap_888 {

    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            }else if (arr[mid] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int [] res = new int[2];
        Arrays.sort(bobSizes);
        int aliceTotalCandies = Arrays.stream(aliceSizes).sum();
        int bobTotalCandies = Arrays.stream(bobSizes).sum();

        int targetCandies = (aliceTotalCandies + bobTotalCandies)/2;


        for(int i=0; i< aliceSizes.length; i++){
            int bi = search(bobSizes,  targetCandies  - aliceTotalCandies + aliceSizes[i]);
            if(bi != -1){
                res[0] = aliceSizes[i];
                res[1] = bobSizes[bi];
                return res;
            }
        }
        return res;
    }



}
