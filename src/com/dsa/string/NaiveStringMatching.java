package com.dsa.string;

public class NaiveStringMatching {


    /*                 i
    *   s -> abcdacgdfhkiugn -- > 15
    *   p ->           fhkiugnn --> 5
    *
    *
    *
    *
    * */

    public static int matchPatternNaive(String s, String p) {
        int m = s.length(), n = p.length();
        for(int j=0; j <= m-n; j++){
            int i = 0;
            int k = j;
            while(i < n && s.charAt(k) == p.charAt(i)){
                i++;
                k++;
            }
            if(i == n){
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(matchPatternNaive("abcdacgdfhkiugn", "fhkiugnn"));

    }
}
