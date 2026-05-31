package com.dsa.sorting;

import java.util.Arrays;

class Heap{
    int [] arr;
    int heapSize;
    int len;
    public Heap(int [] arr){
        this.arr = arr;
        this.heapSize = arr.length;
        this.len = arr.length;
    }
    public int left(int i){
        return 2 *i + 1;
    }
    public int right(int i){
        return 2*i + 2;
    }
    public int parent(int i){
        return (i-1)/2;
    }
    public void percolateDown(int i){
        int l = left(i);
        int r = right(i);
        int largest;
        if(l < heapSize && arr[l] >= arr[i]){
            largest = l;
        }else {
            largest = i;
        }
        if(r < heapSize && arr[r] >= arr[largest] ){
            largest = r;
        }
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            percolateDown(largest);
        }
    }
    public void createMaxHeap(){
        for(int i= heapSize/2; i>=0; i--){
            percolateDown(i);
        }
    }
    public void heapSort(){
        createMaxHeap();
        for(int i=len-1; i>=0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSize = heapSize-1;
            percolateDown(0);
        }
    }
}

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {1, -10, 9, 7, 8, 10};
        Heap maxHeap = new Heap(arr);
        maxHeap.heapSort();
        System.out.println(Arrays.toString(maxHeap.arr));
        int [] arr2 = { -10, 79, 8, 4, 2, 80};
        maxHeap = new Heap(arr2);
        maxHeap.heapSort();
        System.out.println(Arrays.toString(arr2));

    }
}
