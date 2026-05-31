package com.dsa.recursion;

import java.util.Stack;

public class ReverseAStack {
    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()) return;
        int top = s.pop();
        reverse(s);
        insertBottom(s, top);
    }
    public static void insertBottom(Stack<Integer> s, int data){
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        insertBottom(s, data);
        s.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        System.out.println(stack);
    }
}


