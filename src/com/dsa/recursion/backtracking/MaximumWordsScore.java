package com.dsa.recursion.backtracking;

public class MaximumWordsScore {

    public static boolean isPickable(String word, int []freq){
        int [] freqWord = new int[26];
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            freqWord[c-'a']++;
        }
        for(int i=0; i< 26; i++){
            if(freq[i] < freqWord[i]) return false;
        }
        return true;
    }
    public int getScoreOfAWord(String word, int [] score){
        int scr = 0;
        for(int i=0; i< word.length(); i++){
            scr += score[word.charAt(i)-'a'];
        }
        return scr;
    }
    public void decrementFreqArray(String word, int [] freq){
        for(int i=0; i< word.length(); i++){
            freq[word.charAt(i)-'a']--;
        }
    }
    public void incrementFreqArray(String word, int [] freq){
        for(int i=0; i< word.length(); i++){
            freq[word.charAt(i)-'a']++;
        }
    }
    public void solve(String [] words, int index, int [] score, int [] freq, int sum, int maxSum[]){
        if(index == words.length){
            maxSum[0] = Math.max(maxSum[0], sum);
            return;
        }
        String word = words[index];
        if(isPickable(word, freq)){
            int scr = getScoreOfAWord(word, score);
            decrementFreqArray(word, freq);
            sum += scr;
            solve(words, index+1, score, freq, sum, maxSum);
            incrementFreqArray(word, freq);
            sum -= scr;
            solve(words, index+1, score, freq, sum, maxSum);
        }else{
            solve(words, index+1, score, freq, sum, maxSum);
        }
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int [] freq = new int[26];
        for(int i=0; i< letters.length; i++){
            char c = letters[i];
            freq[c-'a']++;
        }
        int [] maxSum = new int[]{Integer.MIN_VALUE};
        solve(words, 0, score, freq, 0, maxSum);
        return maxSum[0];
    }

    public static void main(String[] args) {
        MaximumWordsScore maximumWordsScore = new MaximumWordsScore();
        String [] words = {"dog","cat","dad","good"};
        char [] letters = {'a','a','c','d','d','d','g','o','o'};
        int score [] = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(maximumWordsScore.maxScoreWords(words, letters, score));
    }
}
