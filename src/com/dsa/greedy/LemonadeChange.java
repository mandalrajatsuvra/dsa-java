package com.dsa.greedy;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {

    public static boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int bill : bills) {
            if(bill == 5){
                map.put(bill, map.getOrDefault(bill, 0) + 1);
            }else if(bill == 10){
                int freqOf5 = map.getOrDefault(5, 0);
                if(freqOf5 == 0){
                    return false;
                }else{
                    map.put(5, freqOf5 - 1);
                }
                map.put(bill, map.getOrDefault(bill, 0) + 1);
            }else{
                int freqOf5 =  map.getOrDefault(5, 0);
                int freqOf10 =  map.getOrDefault(10, 0);
                if(freqOf5 >= 1 && freqOf10 >= 1){ // Here is the greedy choice we are saving 5
                    map.put(5, freqOf5 - 1);
                    map.put(5, freqOf10 - 1);
                } else if(freqOf5 >= 3){
                    map.put(5, freqOf5 - 3);
                } else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5}));
    }
}
