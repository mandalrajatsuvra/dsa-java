package com.dsa.recursion.backtracking;

public class LongestSubsequenceRepeatedKTimes {
    public static boolean presentKTimesInString(String in, String out, int k){
        int i=0;
        int j =0;
        while (i< in.length() && j < k * out.length()){
            if(in.charAt(i) == out.charAt(j % out.length())){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j == k * out.length();
    }
    public static void generateSubsequence(String in, String out, int index, int []freq, int k, boolean[] canUse, String[] res){

        if(out.length() > in.length()/k) return;

        if(index == in.length()){
            if(presentKTimesInString(in, out, k)){
                if(out.length() > res[0].length() ||   (out.length() == res[0].length() && out.compareTo(res[0]) > 0 )){
                    res[0]= out;
                    System.out.println(res[0]);
                }
            }
            return;
        }
        char ch = in.charAt(index);
        if(canUse[ch-'a'] && freq[ch-'a'] >= 1){
            freq[ch-'a']--;
            generateSubsequence(in, out+ch, index+1, freq, k , canUse, res );
            freq[ch -'a']++;
            generateSubsequence(in, out, index+1, freq, k, canUse, res );
        }else{
            generateSubsequence(in, out, index+1, freq, k, canUse, res);
        }

    }

    public static String longestSubsequenceRepeatedK(String s, int k) {
        int [] freq = new int[26];
        for(int i=0; i< s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }
        boolean [] canUse = new boolean[26];
        for(int i=0; i< s.length(); i++){
            if(freq[s.charAt(i) -'a'] >=k){
                canUse[s.charAt(i)-'a'] = true;
            }
        }
        String [] res = new String[]{""};
        generateSubsequence(s, "", 0, freq, k, canUse, res);
        return res[0];
    }
    public static void main(String[] args) {
        longestSubsequenceRepeatedK("letsleetcode", 2);
        longestSubsequenceRepeatedK("bb", 2);
        //System.out.println(presentKTimesInString("letsleetcode", "let", 2));
        System.out.println(longestSubsequenceRepeatedK("bwonderwonderwonderwonderwonderwonderwonderwonderb", 8));

    }
}
