package com.dsa.recursion.permutations;


public class RemoveDuplicate {
    public boolean hasDuplicateConsecutive(String s){
        if(s.length() ==0) return false;
        char [] ch = s.toCharArray();
        int i =1;
        char prev = ch[0];
        while (i < ch.length){
            if(ch[i] == prev){
                return true;
            }else{
                prev=ch[i];
            }
            i++;
        }
        return false;
    }

    public  String removeDuplicate(String s){
        String res = "";
        int i =0;
        while(i < s.length()){
            int j = i;
            char start = s.charAt(i);
            int run =0;
            while (j < s.length() && s.charAt(j) == start){
                j++;
                run++;
            }
            if(run == 1){
                res+= start;
            }
            i = j;
        }
        return res;
    }


    public String removeUtil(String s) {
        if(!hasDuplicateConsecutive(s)){
            return s;
        }
        String s1 = removeDuplicate(s);
        return removeUtil(s1);
    }

    public static void main(String[] args) {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        System.out.println(removeDuplicate.removeUtil("abccbccba"));
        System.out.println(removeDuplicate.removeUtil("geeksforgeekseeee"));
    }
}
