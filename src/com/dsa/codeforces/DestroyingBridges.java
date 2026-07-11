package com.dsa.codeforces;

import java.util.Scanner;

public class DestroyingBridges {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            int v =  sc.nextInt();
            int d = sc.nextInt();
            if(d >= v-1){
                System.out.println(1);
            }else{
                System.out.println(v);
            }
        }
    }
}
