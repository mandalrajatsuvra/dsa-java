/*



Input: arr1[] = [1, 2, 4, 4 , 4, 6], arr2[] = [4, 5, 6, 9, 10, 11]

  1 2 4 4 4      6 9 10 11
   6             4 5

Output: 9
Explanation: The merged array looks like [1, 2, 4, 4, 4, 4, 5, 6 ,6, 9, 10, 11]
l = 1, h = 11 m = 6
l=1 h =5 m = 3



arr1[] = [1, 2, 4, 6], arr2[] = [7, 8, 9, 10]

how many elements we are taking from the first arr that is the question 0, 1, 2,3, 4,
l =0, r = 4, m = 2


l1 = m-1 = 1 l2 = 2
l2 = 4-m-1 = 4-m-1 = 2

l = 3, r = 4 m = 3
l1 = 2 r1 = 3
r1 = 4-2-2 = 1  r2 = r1 + 1
1 2, 4   |   6

7   |     8 9 10



1 2  4 6 |   INT_MAX
INT_MIN  |  4, 5, 6, 9


[1, 2, 4, 4, 5, 6, 6, 9,].

*/


package com.dsa.binary_serach_technique;

public class BinarySearchInRotatedSortedArrayGFG {



    public int searchMinIndex(int []arr , int low, int high) {
         if(low > high){
             return -1;
         }
         int mid =  low + (high - low)/2;

         if(arr[mid] == arr[low] && arr[mid] == arr[high]){

         }



        return 0;

    }

    public boolean binarySearch(int [] arr, int left, int right, int target) {
        if(left > right)
            return false;
        int mid = (left+right)/2;
        if(arr[mid] == target){
            return true;
        }





        return false;

    }

    public boolean search(int[] arr, int key) {

        int start = 0;
        int end = arr.length-1;




        return binarySearch(arr, start, end, key);

    }
    public static void main(String[] args) {

    }
}
