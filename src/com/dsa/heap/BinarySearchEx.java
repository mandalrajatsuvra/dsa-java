package com.dsa.heap;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinarySearchEx {
    /*
    * 1221
    *
    *
    * */
    public static boolean isPalindrome(int x, int i, int j){
        int len = length(x);
        return solve(x, 1, len);
    }
    public static boolean solve(int x, int i, int j){
        if(i > j){
            return true;
        }
        int last = x % (int)Math.pow(10, i);
        int first = x /  (int)Math.pow(10, j-1);
        if(last != first){
            return false;
        }

        int x1 = x%(int) Math.pow(10, j-1);
        x1 = x1 % 10;

        return solve(x1, i+1, j-1);
    }
    public static int length(int x){
        int len = 0;
        while (x > 0){
            x = x/10;
            len++;
        }
        return len;
    }
    public static int binarySearch(int [] arr, int x){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == x){
                return  mid;
            }else if(arr[mid] > x){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = {20,34,36,45,50,65,83,98,123};
        System.out.println(binarySearch(arr, 36));
        Arrays.stream(arr).mapToObj(Integer::valueOf).collect(Collectors.toList());
    }
}
