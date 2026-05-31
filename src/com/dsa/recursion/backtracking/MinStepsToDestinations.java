package com.dsa.recursion.backtracking;

import java.util.HashMap;

public class MinStepsToDestinations {

    static int solve(int steps, int d, int pos, HashMap<String, Integer> dp ){
        if(pos == d){
            return 0;
        }else if(Math.abs(pos) > d){
            return (int) 1e9;
        }
        String key = pos + "+"+ steps;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int left =  1 + solve(steps + 1 , d, pos - steps, dp);
        int right = 1 + solve(steps + 1 , d, pos + steps, dp);
        int res = Math.min(left,right);
        dp.put(key, res);
        return res;
    }

    public static int minSteps(int d) {
        HashMap<String, Integer> dp = new HashMap<>();
        return solve(1, d, 0, dp);
    }

    public static void main(String[] args) {
        MinStepsToDestinations m = new MinStepsToDestinations();
        System.out.println(m.minSteps(10000));
    }
}
