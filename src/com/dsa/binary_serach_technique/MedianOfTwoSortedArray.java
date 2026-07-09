package com.dsa.binary_serach_technique;

public class MedianOfTwoSortedArray {
    // Correct answer
    public double medianOf2(int a[], int b[]) {

        if(a.length > b.length){
            return medianOf2(b,a);
        }

        int start = 0;
        int end = a.length;

        int n = a.length;
        int m = b.length;

        int midCount = (n+m+1)/2;
        int totalLength = n+m;

        while(start <= end){
            int mid =  start + (end - start)/2;



            int l1 = mid >= 1 ? a[mid-1] : Integer.MIN_VALUE;
            int r1 = mid < n ? a[mid] : Integer.MAX_VALUE;
            int l2 = midCount - mid >= 1 ? b[midCount-mid-1] : Integer.MIN_VALUE;
            int r2 = midCount - mid + 1 <= m ? b[midCount-mid] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                if(totalLength%2 == 0){
                    return ((double)Math.max(l1,l2) + (double) Math.min(r1, r2))/2d;
                }else{
                    return  Math.max(l1, l2);
                }
            }else if(l1 > r2){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return (double) -1;
    }

    public static void main(String[] args) {
        int [] a = {6402, 9802, 9988, 12763, 15913, 20758, 25833, 28371, 31516, 33612,
                33923, 34462, 41400, 43353, 48078, 51215, 51305, 56422, 59024, 60205,
                63633, 66669, 68112, 70150, 79160, 80391, 80882, 82067, 82754, 86007,
                87117, 87316, 88213, 91391, 92116, 99660};
        int [] b = {5823, 7172, 8508, 22397, 27820, 30621, 37554, 44104, 46379, 48434,
                52324, 67532, 88508, 89210};
        MedianOfTwoSortedArray m = new MedianOfTwoSortedArray();
        System.out.println(m.medianOf2(a,b));
    }


}
