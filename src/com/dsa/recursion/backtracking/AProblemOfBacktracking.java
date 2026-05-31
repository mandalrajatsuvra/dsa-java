package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class AProblemOfBacktracking {

    public static boolean solve(int index, ArrayList<Integer> in, HashSet<Integer> used, ArrayList<Integer> res, ArrayList<Integer> coefficient, int k, int sum){
        if(res.size() == in.size()){
            return sum <= k;
        }
        for(int i=0; i< in.size(); i++){
            if(!used.contains(in.get(i))){
                used.add(in.get(i));
                res.add(in.get(i));
                sum += coefficient.get(index)*res.get(index);
                if(solve(index+1, in, used, res, coefficient, k, sum )){
                    return true;
                }
                sum -= coefficient.get(index)*res.get(index);
                used.remove(in.get(i));
                res.remove(res.size()-1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> coefficientList = new ArrayList<>();
        ArrayList<Integer> kList = new ArrayList<>();
        while (n-- > 0){
            ArrayList<Integer> coefficient = new ArrayList<>();
            for(int i=0; i< 10; i++) {
                coefficient.add(sc.nextInt());
            }
            coefficientList.add(coefficient);
            int k = sc.nextInt();
            kList.add(k);
        }

        for(int i=0; i< coefficientList.size(); i++){
            ArrayList<Integer> in = new ArrayList<>();
            for(int t=0; t< 10; t++){
                in.add(t);
            }
            HashSet<Integer> used  = new HashSet<>();
            ArrayList<Integer> res = new ArrayList<>();
            if(solve(0, in, used, res, coefficientList.get(i), kList.get(i), 0)){
                for(int j=0; j< res.size(); j++){
                    System.out.print(res.get(j) +" ");
                }
                System.out.println();
            }else{
                System.out.println(-1);
            }
        }
    }
}
