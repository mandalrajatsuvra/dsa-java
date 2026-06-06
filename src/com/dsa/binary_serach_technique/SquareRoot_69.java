package com.dsa.binary_serach_technique;

public class SquareRoot_69 {

    public int mySqrt(int x) {

        int low = 0;
        int high = x;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {

    }
}
