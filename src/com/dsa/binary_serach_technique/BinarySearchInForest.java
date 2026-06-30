package com.dsa.binary_serach_technique;

public class BinarySearchInForest {

    static int findHeight(int tree[], int n, int k) {
        int high = -1;
        for (int i = 0; i < n; i++) {
            high = Math.max(high, tree[i]);
        }
        int low = 0;
        while (low <= high){
            int mid = (low + high)/2;
            int totalCollectedWood = collectedWood(tree, mid);
            if (totalCollectedWood == k) {
               return mid;
            }else if (totalCollectedWood > k) {
                low = mid + 1;
            }else  {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int collectedWood(int[] tree, int mid) {
        int collectedWood = 0;
        for(int eachHeight : tree) {
            if(eachHeight > mid) {
                collectedWood += (eachHeight - mid);
            }
        }
        return collectedWood;
    }

    public static void main(String[] args) {

    }
}
