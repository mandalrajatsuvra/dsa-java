package com.dsa.recursion;

public class JosephusProblem {
    public static int josephus(int n, int k) {
        boolean [] killed = new boolean[n];
        int personLeft = n;
        int index = 0;
        while(true){
            int kill = (k-1) % personLeft;
            while(kill  > 0){
                index = (index+1)%n;
                if(!killed[index]){
                    kill--;
                }
            }
            killed[index] = true;
            personLeft --;
            if(personLeft == 1){
                break;
            }
            while(killed[index]){
                index = (index +1) % n;
            }
        }
        for(int i=0; i<n ;i++){
            if(!killed[i]){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(josephus(5, 2));
    }
}
