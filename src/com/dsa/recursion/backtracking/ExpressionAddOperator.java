package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExpressionAddOperator {


    public void solve(int pos , String pr, ArrayList<String> res){
        res.add(pr);
        char [] operators = {'+', '-', '*'};
        for(int i=pos+1; i <= pr.length(); i++){
            String prefix = pr.substring(0, i);
            String suffix = pr.substring(i);
            if(!prefix.isEmpty() && !suffix.isEmpty()){
                for(int j=0; j < operators.length; j++){
                    pr = prefix + operators[j] + suffix;
                    solve(i+1, pr, res);
                    pr = prefix + suffix;
                }
            }
        }
    }
    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> res = new ArrayList<>();
        solve(0, s, res);
        System.out.println(res);
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i< res.size(); i++){
            if(isValidSequence(res.get(i))) {
                ArrayList<String> postFixExpression = postFixExpression(tokens(res.get(i)));
                int value = evalPostFix(postFixExpression);
                if (value == target) {
                    list.add(res.get(i));
                }
            }
        }
        return list;
    }

    private boolean isValidSequence(String s) {
        int i=0;
        String token = "";
        while (i < s.length()) {
            if(s.charAt(i) >= '0' &&  s.charAt(i) <= '9') {
                token += s.charAt(i);
            }else{
                if(token.charAt(0) == '0' && token.length() >1){
                    return false;
                }
                token = "";
            }
            i++;
        }
        if(token.charAt(0) == '0' && token.length() >1){
            return false;
        }
        return true;
    }

    public ArrayList<String> tokens(String s){
        ArrayList<String> res = new ArrayList<>();
        int i =0;
        String token = "";
        while(i<s.length()){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                token += s.charAt(i);
            }else{
                res.add(token);
                token = "";
                res.add(String.valueOf(s.charAt(i)));
            }
            i++;
        }
        if(!token.isEmpty()){
            res.add(token);
        }
        return res;
    }
    public boolean isOperator(String s){
        return "*".equals(s) || "+".equals(s) || "-".equals(s);
    }
    public ArrayList<String> postFixExpression(ArrayList<String> res){
        ArrayList<String> postFixExpression = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        Map<String,Integer> preside = new HashMap<>();
        preside.put("*",2);
        preside.put("+",1);
        preside.put("-",1);
        for(String s: res){
            if(isOperator(s)){
                while(!stack.isEmpty() && preside.get(stack.peek()) >= preside.get(s)){
                    postFixExpression.add(stack.pop());
                }
                stack.push(s);
            }else{
                postFixExpression.add(s);
            }
        }
        while(!stack.isEmpty()){
            postFixExpression.add(stack.pop());
        }
        return postFixExpression;
    }
    public int evalPostFix(ArrayList<String> res){
        Stack<String> stack = new Stack<>();
        for(String s: res){
            if(isOperator(s)){
                int op2 =  Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                if("+".equals(s)){
                    stack.push(String.valueOf(op1+op2));
                }else if("-".equals(s)){
                    stack.push(String.valueOf(op1 -op2));
                }else{
                    stack.push(String.valueOf(op1*op2));
                }
            }else{
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.peek());
    }
    public static void main(String[] args) {
        ExpressionAddOperator exp = new ExpressionAddOperator();
        System.out.println(exp.findExpr("105", 6));
    }
}
