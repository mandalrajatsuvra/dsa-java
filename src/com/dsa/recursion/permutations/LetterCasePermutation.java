package com.dsa.recursion.permutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCasePermutation {

    public static void permutations(char[] arr, int index, Map<Character, String> map, String pr, List<String> res){
        if(index == arr.length){
            res.add(new String(pr));
            return;
        }
        String s = map.get(arr[index]);
        for(int i=0; i< s.length(); i++){
            pr = pr + s.charAt(i);
            permutations(arr, index+1, map, pr, res);
            pr = pr.substring(0, pr.length()-1);
        }
    }
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6',"mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9',"wxyz");
        permutations(digits.toCharArray(), 0, map, "", res);
        return res;
    }

    public static void main(String[] args) {
        List<String> perms = letterCombinations("23");
        System.out.println(perms);
    }
}
