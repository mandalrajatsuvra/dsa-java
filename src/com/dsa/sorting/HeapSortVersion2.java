package com.dsa.sorting;

import java.util.Arrays;

public class HeapSortVersion2 {
    int [] arr;
    int heapSize;
    int len;
    public HeapSortVersion2(int []arr){
        this.arr= arr;
        this.heapSize = arr.length;
        this.len = arr.length;
    }
    public int left(int i){
        return 2*i+1;
    }
    public int right(int i){
        return 2*i + 2;
    }
    public void maxHeapify(int i){
        int l = left(i);
        int r = right(i);
        int largest;
        if(l< heapSize && arr[l]>= arr[i]){
            largest = l;
        }else{
            largest=i;
        }
        if(r < heapSize && arr[r] >= arr[largest]){
            largest = r;
        }
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            maxHeapify(largest);
        }
    }
    public void buildMaxHeap(){
        for(int i= heapSize/2 ; i>=0 ; i--) {
            maxHeapify(i);
        }
    }

    public void heapSort(){
        buildMaxHeap();
        for(int i=len-1; i >=1; i--){
            int temp = arr[i];
            arr[i]= arr[0];
            arr[0] = temp;
            heapSize --;
            maxHeapify(0);
        }
    }

    public static void main(String[] args) {
        int arr[]= {1, -10, 7, 5, 4, 2, 4, 0};
        HeapSortVersion2 heapSortVersion2 = new HeapSortVersion2(arr);
        heapSortVersion2.heapSort();
        System.out.println(Arrays.toString(heapSortVersion2.arr));
    }
}
