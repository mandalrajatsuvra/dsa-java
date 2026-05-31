package com.dsa.loops;

public class BasicPattern {


    public static void  printPattern7(int n){
        int i =1;
        while (i<= n){
            int j = n - i + 1;
            while (j >= 1){
                System.out.print('*');
                j--;
            }
            System.out.println();
            i++;
        }

    }


    public static void printPattern6(int n){
        int i = 1;
        while (i <= n){
            int j=1;
            int p = i;
            while (j <= i){
                System.out.print(p);
                p = p + 1;
                j++;
            }
            System.out.println();
            i++;
        }
    }

    public static void printPattern5(int n) {
        int i=1;
        int p=0;
        while (i<= n){
            int j=1;
            while(j <= i){
                ++p;
                System.out.print(p);
                j++;
            }
            System.out.println();
            i++;
        }
    }
    public static void  printPattern4(int n) {
        int i = 1;
        while(i <= n){
            int j = 1;
            while (j <= i){
                System.out.print(j);
                j++;
            }
            System.out.println();
            i++;
        }
    }
    public static void  printPattern3(int n) {
        int i = 1;
        while(i <= n){
            int j = 1;
            while (j <= n){
                System.out.print(n-j+1);
                j++;
            }
            System.out.println();
            i++;
        }
    }
    public static void  printPattern2(int n) {
        int i =1;
        while(i <= n){
            int j=1;
            while (j <= n){
                System.out.print(i);
                j++;
            }
            System.out.println();
            i++;
        }
    }
    public static void printPattern1(int n) {
        int i=1;
        while (i<= n){
            int j=1;
            while(j<= n){
                System.out.print("* ");
                j++;
            }
            System.out.println();
            i+=1;
        }
    }
    public static void main(String[] args) {
        printPattern1(10);
        printPattern2(4);
        printPattern3(4);
        printPattern4(4);
        printPattern5(4);
        printPattern6(4);
        printPattern7(4);
    }
}
