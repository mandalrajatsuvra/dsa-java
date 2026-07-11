package com.dsa.greedy;

public class LexicographicallySmallestPalindrome {

    public String makeSmallestPalindrome(String s) {
        char [] ch = s.toCharArray();
        int start = 0;
        int end = ch.length - 1;
        while (start < end) {
             if (ch[start] > ch[end]) {
                ch[start] = ch[end];
            }else{
                ch[end] = ch[start];

            }
            start++;
            end--;
        }
        return String.valueOf(ch);
    }

}
