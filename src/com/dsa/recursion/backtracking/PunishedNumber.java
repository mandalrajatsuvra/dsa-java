package com.dsa.recursion.backtracking;

public class PunishedNumber {


    public static boolean canPartition(int sum, int index, String num){
        if(index == num.length()){
            return sum ==0;
        }
        for(int i=index+1; i<= num.length(); i++){
            String token = num.substring(index, i);
            int tokenInt = Integer.parseInt(token);
            sum = sum- tokenInt;
            if(canPartition(sum, i, num)) return true;
            sum = sum + tokenInt;
        }
        return false;
    }

    public static int punishmentNumber(int n) {
        int sum = 0;
        for(int i=1 ; i<= n; i++){
            if(canPartition(i,0,String.valueOf(i*i))){
                sum += i*i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(punishmentNumber(37));
        System.out.println(punishmentNumber(10));
    }
}
