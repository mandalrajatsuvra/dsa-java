package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.HashSet;

public class SudokuSolver {

    public boolean solve(int row, int col, ArrayList<ArrayList<Character>> arr, ArrayList<HashSet<Character>> rows, ArrayList<HashSet<Character>> cols, ArrayList<ArrayList<HashSet<Character>>> boxes) {
        if (row == 9) return true;
        if (col == 9) {
            return solve(row + 1, 0, arr, rows, cols, boxes);
        }

        if (arr.get(row).get(col) == '.') {
            for (char c = '1'; c <= '9'; c++) {
                int boxRow = row / 3;
                int boxCol = col / 3;
                if (!rows.get(row).contains(c) && !cols.get(col).contains(c) && !boxes.get(boxRow).get(boxCol).contains(c)) {
                    rows.get(row).add(c);
                    cols.get(col).add(c);
                    boxes.get(boxRow).get(boxCol).add(c);
                    arr.get(row).set(col, c);
                    if (solve(row, col + 1, arr, rows, cols, boxes)) {
                        return true;
                    }
                    rows.get(row).remove(c);
                    cols.get(col).remove(c);
                    boxes.get(boxRow).get(boxCol).remove(c);
                    arr.get(row).set(col, '.');
                }
            }
        } else {
            return solve(row, col + 1, arr, rows, cols, boxes);
        }
        return false;
    }


    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        ArrayList<HashSet<Character>> rows = new ArrayList<>();
        ArrayList<HashSet<Character>> cols = new ArrayList<>();
        ArrayList<ArrayList<HashSet<Character>>> boxes = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }
        for (int i = 0; i < 3; i++) {
            ArrayList<HashSet<Character>> eachBox = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                eachBox.add(new HashSet<>());
            }
            boxes.add(eachBox);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; i++) {
                if (a.get(i).get(j) != '.') {
                    rows.get(i).add(a.get(i).get(j));
                    cols.get(j).add(a.get(i).get(j));
                    int boxesRow = i / 3;
                    int boxesCol = j / 3;
                    boxes.get(boxesRow).get(boxesCol).add(a.get(i).get(j));
                }
            }
        }
        solve(0, 0, a, rows, cols, boxes);
    }

    public static void main(String[] args) {



    }

}




