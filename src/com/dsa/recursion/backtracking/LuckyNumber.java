package com.dsa.recursion.backtracking;

public class LuckyNumber {


    public static boolean solve(int pos, int steps){
        if(pos % steps == 0){
            return false;
        }else if(steps > pos){
            return true;
        }
        return solve(pos - pos/steps, steps + 1);
    }

    public static boolean isLucky(int n) {
        return solve(n, 2);
    }
    public static void main(String[] args) {
        System.out.println(isLucky(5));
    }
}
