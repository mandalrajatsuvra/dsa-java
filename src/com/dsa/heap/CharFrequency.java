package com.dsa.heap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CharFrequency {
    public static int calculateCount2(List<Integer> list){
        int count = 0;
        List<String> numsList = list
                .stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        for(String s: numsList){
            char [] ch = s.toCharArray();
            for(int i=0; i<ch.length; i++){
                if(ch[i] =='2'){
                    count++;
                }
            }
        }
        return count;
    }

    /*AAAABBBAA
    * 4A3B2A
    * */
    public static String calculateFreq(String s){
        String out = "";
        char [] ch = s.toCharArray();
        char prev = ch[0];
        int pos = 0;
        while (pos < ch.length){
            int count = 0;
            while(pos < ch.length && ch[pos] == prev){
                count++;
                pos++;
            }
            out += count;
            out += prev;
            if(pos < ch.length)
                prev = ch[pos];
        }
        return out;
    }
    public static void main(String[] args) {
        System.out.println(calculateFreq("AAAABBBAACCB"));
        System.out.println( calculateCount2(Arrays.asList(22, 23, 24, 66 , 65, 200, 100)));
    }
}
