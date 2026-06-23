package com.dsa.binary_serach_technique;

public class BitonicPointGFG {

    /*
    *arr[] = [1, 2, 4, 5, 7, 8, 3]
    *
    *l = 1 r= 5   m = 3
    *
    * l = 4, r = 5 m = 4
    *
    * 10, 20, 30, 40, 50
    *
    * l = 0, r= 4 m = 2
    * l = 3,  r = 4 m = 3
    * l = 4,
    *
    *
    * 120, 100, 80, 20, 0
    *
    * l = 0, r = 4 m = 2
    * l =0, r = 1;   m = 0
    * l=1, r =1  mid =1
    *
    *[1, 5, 4 ,3, 2]
    *
    *
    * l= 0, r = 4 m = 2 arr[mid] = 4  res = 4,
    *
    * l =0, r = 1  mid = 0
    *
    *
    *
    *
    * */
    // Problem here is we are using bs 2 times the solutions is correct but not Good solution;

    public int bs(int[] arr) {

        if(arr[0] > arr[1]){
            return arr[0];
        }
        int n = arr.length;
        if(arr[n-1] > arr[n-2]){
            return arr[n-1];
        }
        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1] ) {
                return arr[mid];
            }else if(arr[mid] > arr[mid - 1]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public void bs(int []arr, int left, int right, int [] res) {
        if (left > right) {
            return;
        }
        int mid = (left + right) / 2;
        if(arr[mid]  >= arr[left] &&  arr[mid] >= arr[right]) {
            res[0] = Math.max(arr[mid], res[0]);
            bs(arr, mid + 1, right, res);
            bs(arr, left, mid - 1, res);
        }else if(arr[mid] >= arr[left]) {
            res[0] = Math.max(arr[mid], res[0]);
            bs(arr, mid+1, right, res);
        }else if(arr[mid] >= arr[right]) {
            res[0] = Math.max(arr[mid], res[0]);
            bs(arr, left, mid-1, res);
        }
    }
    public int findMaximum(int[] arr) {
        int res[] = new int[]{0};
        bs(arr, 0, arr.length - 1, res);
        return res[0];
    }
    public static void main(String[] args) {
        BitonicPointGFG obj = new BitonicPointGFG();
        int []arr = {1, 3, 2};
        System.out.println(obj.findMaximum(arr));
    }
}
