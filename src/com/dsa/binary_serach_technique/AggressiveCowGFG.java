package com.dsa.binary_serach_technique;

import java.util.Arrays;

public class AggressiveCowGFG {

    /*
    *
    * 1, 2, 4, 8, 9
    *
    * l = 1 h = 8 m = 4
    * l=1 h = 3 m = 2
    *
    *
    *
    * */


    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1, high = stalls[n-1]- stalls[0];
        int ans = 0;
        while(low <= high){
            int mid = (low+high)/2;
            if(canAssignCowWithDiff(stalls,  mid, k)){
                ans = mid;
                low = mid+1;
            }else {
                high = mid-1;
            }
        }

        return ans;
    }
    /*
    *
    *
    *
    * */
    private boolean canAssignCowWithDiff(int [] stalls ,int diff, int k) {
        int cnt = 1;
        int currentSelectedStall = 0;
        for(int i=1; i<stalls.length; i++){
            if(stalls[i] - stalls[currentSelectedStall] >= diff ){
                cnt++;
                currentSelectedStall = i;
            }
        }
        return cnt >= k;
    }
}
