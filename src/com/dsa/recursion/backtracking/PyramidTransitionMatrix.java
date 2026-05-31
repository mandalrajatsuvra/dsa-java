package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidTransitionMatrix {


    public boolean solve(int index, String bottom,  String pr, Map<String, List<String>> map){
        if(index == bottom.length() - 1){
            if(bottom.length() == 1){
                return true;
            }
            return solve(0, pr, "", map);
        }
        String prefix =  bottom.charAt(index) + "" + bottom.charAt(index+1);
        List<String> bottomList = map.getOrDefault(prefix, new ArrayList<>());
        for(int i=0; i < bottomList.size(); i++){
            pr += bottomList.get(i);
            if(solve(index+1, bottom, pr, map)) return true;
            pr = pr.substring(0, pr.length()-1);
        }
        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {

        Map<String, List<String>> map = new HashMap<>();
        for(String s: allowed){
            String btm = s.substring(0, s.length()-1);
            String top = s.substring(s.length()-1);
            if(!map.containsKey(btm)){
                List<String> l = new ArrayList<>();
                l.add(top);
                map.put(btm, l);
            }else{
                List<String> l = map.get(btm);
                l.add(top);
            }
        }
        return solve(0, bottom, "", map);
    }

    public static void main(String[] args) {
        PyramidTransitionMatrix pyramidTransitionMatrix = new PyramidTransitionMatrix();
        System.out.println(pyramidTransitionMatrix.pyramidTransition("AAAA", List.of("AAB","AAC","BCD","BBE","DEF", "EDM")));
    }
}
