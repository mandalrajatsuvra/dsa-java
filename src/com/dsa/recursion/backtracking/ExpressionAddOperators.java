package com.dsa.recursion.backtracking;

import java.util.*;

public class ExpressionAddOperators {
    public void solve(int pos , String pr, ArrayList<String> res){
        res.add(pr);
        char [] operators = {'+', '-', '*', '/'};
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
    public void solve(int i, String s, String pr, HashSet<String> res) {
         if(i == s.length()){
             res.add(new String(pr));
             return;
         }
        char[] op = {'+', '-', '*'};
        if(i < s.length() -1){
            for(int j = 0; j < op.length; j++){
                if(s.charAt(i) != '0') {
                    solve(i + 1, s, pr + s.charAt(i) + op[j], res);
                    solve(i + 1, s, pr + s.charAt(i), res);
                }else{
                    solve(i + 1, s, pr + s.charAt(i) + op[j], res);
                }
            }
        }else{
            solve(i+1, s, pr+ s.charAt(i), res);
        }
    }

    public List<String> tokens(String s){
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
        return "*".equals(s) || "+".equals(s) || "-".equals(s) || "/".equals(s);
    }
    public List<String> postFixExpression(List<String> res){
        List<String> postFixExpression = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        Map<String,Integer> preside = new HashMap<>();
        preside.put("/",2);
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
    public long evalPostFix(List<String> res){
        Stack<String> stack = new Stack<>();
        for(String s: res){
            if(isOperator(s)){
                int op2 =  Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                if("+".equals(s)){
                    stack.push(String.valueOf(op1+op2));
                }else if("-".equals(s)){
                    stack.push(String.valueOf(op1 -op2));
                }else if("*".equals(s)){
                    stack.push(String.valueOf(op1*op2));
                }else{
                    if(op2 == 0) return Integer.MAX_VALUE;
                    stack.push(String.valueOf(op1/op2));
                }
            }else{
                stack.push(s);
            }
        }
        return Long.parseLong(stack.peek());
    }

    public List<String> addOperators(String num, int target) {
        ArrayList<String> res = new ArrayList<>();
        solve(0, num, res);
        System.out.println(res);
        List<String> resList = new ArrayList<>();
        for(String s : res){
            if(isValidSequence(s)) {
                List<String> tokenized = tokens(s);
                List<String> postFixExpression = postFixExpression(tokenized);
                if (evalPostFix(postFixExpression) == target) {
                    resList.add(s);
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        ExpressionAddOperators solver = new ExpressionAddOperators();
        List<String> res = solver.addOperators("3456237490", 6);
        System.out.println(res);
    }
}
