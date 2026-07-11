package com.dsa.greedy;

import java.util.Arrays;

public class PartitionTheArrayInto3Parts {
    /*
    *
    *   0 0 0 -7 5 -7 5
    *
    *
    * */
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if(sum % 3 != 0){
            return false;
        }
        int cnt = 0;
        int target = sum / 3;

        int end = 0;
        while(end < arr.length && cnt < 3){
            int curr = 0;
            while(end < arr.length && curr != target){
                curr += arr[end++];
            }
            cnt += 1;
        }
        return cnt == 3;
    }


}
