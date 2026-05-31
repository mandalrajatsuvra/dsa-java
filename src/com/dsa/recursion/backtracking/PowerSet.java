package com.dsa.recursion.backtracking;

import java.util.ArrayList;

public class PowerSet{

    public void solve(int index, String input, String pr, ArrayList<String> res){
        if(index == input.length()){
            res.add(new String(pr));
            return;
        }
        pr = pr  + input.charAt(index);
        solve(index+1, input, pr, res);
        pr = pr.substring(0, pr.length()-1 );
        solve(index+1, input, pr, res);
    }
    public ArrayList<String> powerSet(String s) {
        ArrayList<String> result = new ArrayList<>();
        solve(0, s, "", result);
        return result;
    }

    public static void main(String[] args) {
        PowerSet ps = new PowerSet();
        System.out.println(ps.powerSet("abc"));
    }
}
