package com.dsa.sorting;

import java.util.Arrays;

public class QuickSort {
    public static int partition(int [] arr, int p, int r){
        int i = p-1;
        int pivot = arr[r];
        for(int j=p; j<= r-1; j++){
            if(arr[j] <= pivot){
                i=i+1;
                int temp= arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return i+1;
    }
    public static void quickSort(int [] arr, int low, int high){
        if(low >= high) return;
        int mid = partition(arr, low, high);
        quickSort(arr, low, mid-1);
        quickSort(arr, mid+1, high);
    }
    public static void main(String[] args) {
        int [] arr = {10, -4, 89, 100, -89, 0};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        int [] arr2 = {5, -10, 45, 89, 73, 7};
        quickSort(arr2,0, arr2.length-1);
        System.out.println(Arrays.toString(arr2));
    }
}
