package com.leetcode;

import java.util.HashSet;

//36#， Medium
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board)
    {
        HashSet set = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    if (!set.add(current + " in row " + i) || // 判断行
                            !set.add(current + " in col " + j) ||  // 判断列
                            !set.add(current + " in box " + i / 3 + ", " + j / 3)) // 判断子方格
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        ValidSudoku vs = new ValidSudoku();
        char[][] board = new char[][]
        {{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(vs.isValidSudoku(board));
    }
}
