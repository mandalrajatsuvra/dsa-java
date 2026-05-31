package com.dsa.recursion.backtracking;

import java.util.Stack;

public class DecodeAString {
    /*
    *   Input: s = "3[b2[ca]]"
        Input: s = "3[b2[ca]]"
        Output: "bcacabcacabcaca"
        Explanation:
        Inner substring “2[ca]” breakdown into “caca”.
        Now, new string becomes “3[bcaca]”
        Similarly “3[bcaca]” becomes “bcacabcacabcaca” which is final result.
    *
    *
    * */

    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        int i=0;
        while(i<s.length()){
            if(isDigit(s.charAt(i))){
                String digit = "";
                while (i<s.length()&&isDigit(s.charAt(i))){
                    digit += s.charAt(i);
                    i++;
                }
                count.push(Integer.parseInt(digit));
            }else if(s.charAt(i) == '['){
                stack.push(String.valueOf(s.charAt(i)));
                i++;
            }else if(s.charAt(i) == ']'){
                int cnt = 1;
                if(!count.isEmpty()){
                    cnt = count.pop();
                }
                String result = "";
                while(!stack.isEmpty() && !"[".equals(stack.peek())){
                    result = stack.pop() + result;
                }
                if(!stack.isEmpty() && "[".equals(stack.peek())){
                    stack.pop();
                }
                String res = "";
                for(int j=0;j<cnt;j++){
                    res += result;
                }
                stack.push(res);
                i++;
            }else{
                stack.push(String.valueOf(s.charAt(i)));
                i++;
            }
        }
        String result = "";
        while(!stack.isEmpty()){
            result = stack.pop() + result;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a]2[bc]cd"));
        System.out.println(decodeString("3[b2[ca]]"));
    }
}
