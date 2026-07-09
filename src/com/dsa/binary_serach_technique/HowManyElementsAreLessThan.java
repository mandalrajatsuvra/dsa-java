package com.dsa.binary_serach_technique;

import java.util.ArrayList;
import java.util.Arrays;

public class HowManyElementsAreLessThan {


    public static int countElementsAreLessThan(int b[], int x){
        int strat = 0;
        int end = b.length-1;
        int res = -1;
        while(strat <= end){
            int mid = (strat+end)/2;
            if(b[mid] <= x){
                res = mid;
                strat = mid+1;
            }else{
                end = mid-1;
            }
        }
        return res + 1;
    }


    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        Arrays.sort(b);
        ArrayList<Integer> res = new ArrayList<>();
        for(int t: a){
            res.add(countElementsAreLessThan(b, t));
        }
        return res;
    }

}
