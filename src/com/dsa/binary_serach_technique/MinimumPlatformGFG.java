package com.dsa.binary_serach_technique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumPlatformGFG {
    /*
    *
    * 900, 940, 950, 1100, 1500, 1800
    * 910, 1200, 1120, 1130, 1900, 2000
    *
    * [(900, 1), (910, -1), (940, 1), (950, 1), (1100, 1), (1120, -1), (1130, -1), (1200, -1),(1500,1), (1800,1), (1900, -1), (200, -1)]
    *
    *
    *
    * */
    public int minPlatform(int arr[], int dep[]) {
        List<int[]> arrivalDepartureList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrivalDepartureList.add(new int[]{arr[i], 1});
            arrivalDepartureList.add(new int[]{dep[i], -1});
        }
        Collections.sort(arrivalDepartureList, (a, b)->{
            if(a[0] == b[0]){
                if(a[1] > b[1]){
                    return -1;
                }else if(a[1] < b[1]) {
                    return 1;
                }else{
                    return 0;
                }
            }
           return a[0] - b[0];
        });

        int minPlatForms  = 0;
        int cnt = 0;
        for (int i = 0; i < arrivalDepartureList.size(); i++) {
            cnt += arrivalDepartureList.get(i)[1];
            minPlatForms = Math.max(minPlatForms, cnt);
        }
        return minPlatForms;
    }

    public static void main(String[] args) {
        int[] arr = {2153 ,659, 1721, 1025, 602, 1531, 1832, 829};
        int[] dep = {2204 ,1832, 1949, 2034, 1141, 2033, 1844, 1926};
        System.out.println(new MinimumPlatformGFG().minPlatform(arr, dep));
    }
}
