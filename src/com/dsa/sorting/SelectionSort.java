package com.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {
    // 2, -9, 7, 0, 11, 5
    public static void selectionSort(int []arr){
        for(int i= arr.length-1; i>=0; i--){
            int max = arr[i];
            int maxIndex = i;
            for(int j=0; j<= i; j++){
                if(arr[j] > max){
                    max = arr[j];
                    maxIndex= j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int [] arr = {1, 2, -10, 6, -100, 8, 78, 56};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
