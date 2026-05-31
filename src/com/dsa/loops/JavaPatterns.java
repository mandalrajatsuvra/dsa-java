package com.dsa.loops;

import java.util.Scanner;

public class JavaPatterns {


    public static void parallelogramPattern(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=1;
        int spaces = 0;
        while (i <= n){
            int spaceCount = 1;
            while (spaceCount <= spaces){
                System.out.print(' ');
                spaceCount = spaceCount +1;
            }
            int j =1;
            while (j <= n){
                System.out.print('*');
                j = j + 1;
            }
            System.out.println();
            spaces = spaces +1;
            i = i+ 1;
        }
    }
    public static void halfDiamondPattern(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println('*');
        int i =1;
        while (i <= n){
            int j= 1;
            System.out.print('*');
            while(j <= i){
                System.out.print(j);
                j = j+1;
            }
            j -= 2;
            while (j >= 1){
                System.out.print(j);
                j = j -1;
            }
            System.out.print('*');
            System.out.println();
            i = i+1;
        }
        int k = n-1;
        while (k >= 1){
            int j =1;
            System.out.print('*');
            while (j <= k){
                System.out.print(j);
                j= j+1;
            }
            j -= 2;
            while (j >=1){
                System.out.print(j);
                j = j-1;
            }
            System.out.print('*');
            System.out.println();
            k = k-1;
        }
        System.out.print('*');

    }
    public static void diamondStars(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        int starCount = 1;
        boolean isIncreasingStartCount= true;
        while(i <= n){
            int spaceCount = (n-starCount)/2;  // 2
            int j =1;
            while(j <= spaceCount){
                System.out.print(' ');
                j = j+1;
            }
            j =1;
            while (j <= starCount){
                System.out.print('*');
                j = j+1;
            }
            if(starCount == n){
                isIncreasingStartCount = !isIncreasingStartCount;
            }
            if(isIncreasingStartCount) {
                starCount = starCount + 2;
            }else{
                starCount = starCount - 2;
            }
            i = i+ 1;
            System.out.println();
        }
    }
    public static void isoscelesTriangle(int n){
        int i =1;
        while(i <= n){
            int spaces = 1;
            while(spaces <= n-i){
                System.out.print(' ');
                spaces = spaces + 1;
            }
            int p = i-1;
            int inc = 1;
            while (inc <= i){
                p = p+1;
                System.out.print(p);
                inc = inc +1;
            }
            int dec = i-1;
            while (dec >= 1){
                p = p-1;
                System.out.print(p);
                dec = dec -1;
            }
            System.out.println();
            i = i+1;
        }
    }
    public static void  mirrorImagePattern(int n){
        int i = 1;
        while( i <= n){
            int spaces = 1;
            while(spaces <= n-i){
                System.out.print(' ');
                spaces= spaces+1;
            }
            int stars = 1;
            while (stars <= i){
                System.out.print('*');
                stars = stars +1;
            }
            System.out.println();
            i= i+1;
        }
    }


    public static void printPattern4(int n){
        int i= 1;
        while(i <= n){
            int j = 1;
            int p = i;
            while(j <= i){
                System.out.print(p);
                p = p+1;
                j = j+1;
            }
            System.out.println();
            i = i+1;
        }
    }
    public static  void printPattern3(int n){
        int i=1;
        int p = 1;
        while(i <= n){
            int j =1;
            while(j <= i){
                System.out.print(p);
                p= p+1;
                j= j+1;
            }
            System.out.println();
            i= i+1;
        }
    }
    public static void printPattern2(int n){
        int i=1;
        while(i <= n){
            int j=1;
            while(j <= i){
                System.out.print(j);
                j = j+1;
            }
            System.out.println();
            i = i+1;
        }
    }
    public static void printPattern1(int n){
        int i=1;
        while (i <= n){
            int j = 1;
            while (j <= n){
                System.out.print("*");
                j++;
            }
            System.out.println();
            i= i+1;
        }
    }
    public static void main(String[] args) {
        //printPattern1(4);
       // printPattern2(4);
        //printPattern3(4);
        //printPattern4(4);
       // mirrorImagePattern(4);
       // isoscelesTriangle(4);
       // diamondStars();
        //halfDiamondPattern();
        parallelogramPattern();
    }
}
