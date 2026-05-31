package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class StringPermutations {
    public void solve(int pos, char[] ch, ArrayList<String> res ){
        if(pos==ch.length){
            res.add(new String(ch));
            return;
        }
        for(int i = pos; i< ch.length; i++){
            swap(ch, i, pos);
            solve(pos+1, ch, res);
            swap(ch, i, pos);
        }
    }

    private void swap(char[] ch, int i, int pos) {
        char temp =  ch[i];
        ch[i] = ch[pos];
        ch[pos] = temp;
    }

    public ArrayList<String> permutation(String S) {
        char [] ch =  S.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        solve(0,ch,res);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        StringPermutations sp = new StringPermutations();
        System.out.println(sp.permutation("ABC"));
    }
}
