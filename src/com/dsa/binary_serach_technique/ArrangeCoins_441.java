package com.dsa.binary_serach_technique;

public class ArrangeCoins_441 {

    public static int arrangeCoins(int n) {
        int low = 1, high = n;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sum = mid *(mid + 1) / 2;
            if(sum <= n) {
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
    }
}
