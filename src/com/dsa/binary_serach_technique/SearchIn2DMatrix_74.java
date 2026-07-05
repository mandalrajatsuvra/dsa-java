package com.dsa.binary_serach_technique;

public class SearchIn2DMatrix_74 {
    public int searchInColumn(int [][] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int res = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid][0] <= target){
                res = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return res;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int searchIndex = searchInColumn(matrix, target);
        if(searchIndex == -1){
            return false;
        }
        int start = 0;
        int end = matrix[0].length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(matrix[searchIndex][mid] == target){
                return true;
            }else if(matrix[searchIndex][mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return false;
    }
}
