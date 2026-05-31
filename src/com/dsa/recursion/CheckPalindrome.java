package com.dsa.recursion;

public class CheckPalindrome {

    public static boolean isPalindrome(String arr, int s, int e){
        if(s >= e) return true;
        if(arr.charAt(s) != arr.charAt(e)) return false;
        return isPalindrome(arr, s+1, e-1);
    }
    public static void main(String[] args) {
        String palindrome = "madam";
        System.out.println(isPalindrome(palindrome, 0, palindrome.length() -1 ));
        palindrome = "abccba";
        System.out.println(isPalindrome(palindrome, 0, palindrome.length()-1));
        palindrome = "nabccban";
        System.out.println(isPalindrome(palindrome, 0, palindrome.length()-1));

    }
}
