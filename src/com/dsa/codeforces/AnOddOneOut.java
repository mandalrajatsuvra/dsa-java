package com.dsa.codeforces;

import java.util.Scanner;

public class AnOddOneOut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a =  sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int res = 0;
            res = a ^b ^c;
            System.out.println(res);
        }
    }
}
