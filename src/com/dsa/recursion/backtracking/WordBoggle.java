package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBoggle {

    public boolean solve(char[][] board, int x, int y, boolean[][]visited, String word, int pos) {
        if(pos == word.length()){
            return true;
        }
        visited[x][y] =  true;
        int [][] dis = {{-1,0}, {1, 0}, {0, -1}, {0,1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for(int i=0;i<dis.length;i++){
            int x1 = x+dis[i][0];
            int y1 = y+dis[i][1];
            boolean isValidMove = x1 >= 0 && y1 >= 0 && x1 < board.length && y1 < board[0].length && !visited[x1][y1] && board[x1][y1] == word.charAt(pos);
            if(isValidMove) {
                if (solve(board, x1, y1, visited, word, pos + 1)) {
                    return true;
                }
            }
        }
        visited[x][y] = false;
        return false;
    }

    public String[] wordBoggle(char board[][], String[] dictionary) {
        int r = board.length;
        int c = board[0].length;
        List<String> list = new ArrayList<>();

        for(String word : dictionary){
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(board[i][j] == word.charAt(0)){
                        boolean [][] visited = new boolean[r][c];
                        if(solve(board,i,j,visited,word,1)){
                            list.add(word);
                        }
                    }
                }
            }
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        WordBoggle wordBoggle = new WordBoggle();

        char[][] board = {
                {'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}
        };
        String [] dictionary = {"GEEKS","FOR","QUIZ","GO"};

        System.out.println(Arrays.toString(wordBoggle.wordBoggle(board,dictionary)));
    }
}
