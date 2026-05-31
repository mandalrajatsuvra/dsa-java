package com.dsa.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenerateNLengthPasswordUsingKDigits {

    public static void generatePasswords(int n , int k, String pr,
                                         List<String> passwordsList, HashMap<Integer, Integer> marked) {
        if(n < 0) return;
        if(n == 0 && marked.size() == k){
            passwordsList.add(new String(pr));
            return;
        }
        for(int i=1; i<= k; i++){
            marked.put(i, marked.getOrDefault(i, 0)+1);
            pr = pr + i;
            generatePasswords(n-1, k, pr, passwordsList, marked);
            pr = pr.substring(0, pr.length() - 1);
            if(marked.containsKey(i)){
                int freq = marked.get(i);
                if(freq == 1) marked.remove(i);
                else marked.put(i, freq-1);
            }
        }
    }
    public static void main(String[] args) {
        HashMap<Integer, Integer> marked = new HashMap<>();
        List<String> passwords = new ArrayList<>();
        generatePasswords(4, 2, "", passwords, marked);
        System.out.println(passwords);
    }
}
