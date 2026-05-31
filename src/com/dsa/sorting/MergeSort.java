package com.dsa.sorting;

import java.util.Arrays;

public class MergeSort {

    // 0 1 2 3 4 5

    public static void merge(int [] arr, int low, int mid, int high){
        int [] left = new int[mid -low +1];
        int [] right = new int[high-mid];
        int k=-1;
        for(int i=low; i<=  mid; i++){
            left[++k] = arr[i];
        }
        k=-1;
        for(int i= mid+1; i<= high ; i++){
            right[++k] = arr[i];
        }
        int [] merged = new int[left.length+ right.length];
        int i=0;
        int j=0;
        k =0;
        while (i < left.length && j < right.length){
            if(left[i] <= right[j]){
                merged[k++] = left[i++];
            }else{
                merged[k++] = right[j++];
            }
        }
        while(i < left.length){
            merged[k++] = left[i++];
        }
        while (j< right.length){
            merged[k++] = right[j++];
        }
        k =-1;
        for(int t=low; t<= high; t++){
            arr[t] = merged[++k];
        }
    }
    public static void mergeSort(int [] arr, int low, int high){
        if(low >= high) return;
        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
    public static void main(String[] args) {
        int arr[] = {1, -2, 4, -8, 90, 67, 56};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        int arr2 [] = {1, -2, -4, -9};
        mergeSort(arr2, 0, arr2.length-1);
        System.out.println( Arrays.toString(arr2));
    }

}
