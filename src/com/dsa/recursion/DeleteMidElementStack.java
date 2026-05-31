package com.dsa.recursion;

import java.util.Stack;

public class DeleteMidElementStack {

    public static void deleteMidElementStack(Stack<Integer> stack, int s, int popped){
        if(stack.isEmpty()) return;
        int top = stack.pop();
        deleteMidElementStack(stack, s, popped+1);
        if(popped != s/2)
            stack.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        deleteMidElementStack(stack, stack.size(), 0);
        System.out.println(stack);
    }
}
