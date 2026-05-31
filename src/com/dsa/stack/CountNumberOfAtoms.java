package com.dsa.stack;

import java.util.*;

public class CountNumberOfAtoms {
    public static String countNumberOfAtoms(String s) {
        Stack<HashMap<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int i=0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(new HashMap<>());
                i++;
            }else if(c == ')'){
                i++;
                String count = "";
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    count += s.charAt(i);
                    i++;
                }
                HashMap<String, Integer> topMap = stack.pop();
                HashMap<String, Integer> newTop = new HashMap<>();
                for(Map.Entry<String, Integer> m: topMap.entrySet()){
                    newTop.put(m.getKey(),   (count.isEmpty() ? 1 : Integer.parseInt(count) )* m.getValue());
                }
                HashMap<String, Integer> secondTop = stack.pop();
                for(Map.Entry<String, Integer> m: secondTop.entrySet()){
                    if(newTop.containsKey(m.getKey())){
                        newTop.put(m.getKey(), m.getValue() + newTop.get(m.getKey()));
                    }else{
                        newTop.put(m.getKey(), m.getValue());
                    }
                }
                stack.push(newTop);
            }else{
                String atom = "";
                if(Character.isUpperCase(c)){
                    atom += c;
                    i++;
                    while(i < s.length() && Character.isLowerCase(s.charAt(i))){
                        atom += s.charAt(i);
                        i++;
                    }
                }
                String count = "";
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    count += s.charAt(i);
                    i++;
                }
                HashMap<String, Integer> topMap = stack.peek();
                stack.pop();
                if(count.isEmpty()){
                    topMap.put(atom, 1);
                }else{
                    topMap.put(atom, Integer.parseInt(count));
                }
                stack.push(topMap);
            }
        }
        TreeMap<String, Integer> treeMap = new TreeMap<>(stack.peek());
        String res = "";
        for(Map.Entry<String, Integer> m: treeMap.entrySet()){
            res += m.getKey();
            if(m.getValue() > 1){
                res += m.getValue();
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(countNumberOfAtoms("K4(ON(SO3)2)2"));
        System.out.println(countNumberOfAtoms("(H2O2)"));
        System.out.println(countNumberOfAtoms("(H2O2)3"));
    }
}
