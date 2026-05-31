package com.dsa.slidingwindow;

public class MinSwapToGroupAllOnesTogether {

    public int minSwaps(int[] arr) {
        int onesCount = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                onesCount++;
            }
        }
        if(onesCount==0){ return -1;}
        int ones = 0;
        int start =0, end =0;
        int minSwap = Integer.MAX_VALUE;
        while(end < arr.length){
            if(arr[end]==1){
                ones++;
            }
            if(end-start+1 < onesCount){
                end ++;
            }else if(end-start+1 == onesCount){
                minSwap = Math.min(minSwap, onesCount - ones);
                if(arr[start]==1){
                    ones--;
                }
                start++;
                end++;
            }

        }
        return minSwap==Integer.MAX_VALUE ? -1 : minSwap;
    }

    public static void main(String[] args) {
        MinSwapToGroupAllOnesTogether m = new MinSwapToGroupAllOnesTogether();
        int[] arr = {0, 0, 1};
        System.out.println(m.minSwaps(arr));
    }
}
