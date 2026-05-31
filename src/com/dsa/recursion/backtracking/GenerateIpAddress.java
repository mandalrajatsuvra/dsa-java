package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateIpAddress {

    public void solve(int pos, String s, List<String> pr,   List<List<String>> res) {
        if(pos >= s.length()) {
            if(pr.size() == 4) {
                res.add(new ArrayList<>(pr));
            }
            return;
        }

        for(int i= 1; i<= 3; i++ ){
            String prefix = s.substring(pos, Math.min(pos+i, s.length()));
            if(Integer.parseInt(prefix) >= 0 && Integer.parseInt(prefix) <= 255 && !(prefix.length() > 1 && prefix.charAt(0)== '0')) {
                pr.add(prefix);
                solve(pos + i, s, pr, res);
                pr.remove(pr.size() - 1);
            }
        }
    }
    public ArrayList<String> generateIp(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> pr = new ArrayList<>();
        solve(0, s, pr, res);
        ArrayList<String> ipList = new ArrayList<>();
        for(List<String> list : res) {
            String ipAddress = list.get(0) +"."+list.get(1)+"."+list.get(2)+"."+list.get(3);
            ipList.add(ipAddress);
        }
        return ipList;
    }

    public static void main(String[] args) {
        GenerateIpAddress g = new GenerateIpAddress();
        System.out.println(g.generateIp("255678166"));
    }
}
