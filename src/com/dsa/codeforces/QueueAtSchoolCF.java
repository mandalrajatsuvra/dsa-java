package com.dsa.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class QueueAtSchoolCF {


    /*
    *
    * t= 5
    * BBBBBG
    *
    * t=2
    * GBGGBG
    * t=2
    * BBG
    *
    * 5 2
      BGGBG
      *  t ==1
      *
      * GGBGB


    *
    *
    *
    *
    *
    * */

    public static String afterSwap2(String queue, int len, int time){
        char[] arr = queue.toCharArray();
        for(int t=0; t < time; t++){
            boolean []visited = new boolean[len];
            for(int j=1; j< len; j++){
                int i = j-1;
                if(arr[j] == 'G' && arr[i] == 'B' && !visited[i]  && !visited[j]){
                    visited[i] = true;
                    visited[j] = true;
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return new String(arr);
    }


    public static String afterSwap(String queue, int len ,int time){
        char[] arr = queue.toCharArray();
        for(int j=1; j<len; j++){
            if(arr[j] == 'G' && time > 0){
                int i = j-1;
                char temp = arr[j];
                while (i >= 0 && arr[i] == 'B' && time > 0){
                    arr[i+1] = arr[i];
                    i--;
                    time --;
                }
                arr[i+1] = temp;
            }
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int time = in.nextInt();
        String queue = in.next();
        System.out.println(afterSwap2(queue,len,time));
    }
}
