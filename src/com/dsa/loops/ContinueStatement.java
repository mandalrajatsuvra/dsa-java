package com.dsa.loops;

public class ContinueStatement {

    public static void main(String[] args) {

        int n = 5;
        int i =1;
        while (i <= 5){
            if(i == 3){
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }





    }
}
