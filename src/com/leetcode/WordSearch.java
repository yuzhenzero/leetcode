package com.leetcode;

// 79#, Medium
public class WordSearch {
    private int m, n;

    public boolean exist (char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(i, j, 0, board, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack (int i, int j, int index, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n ||
                board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        boolean ans;
        ans = backtrack(i + 1, j, index + 1, board, word) ||
                backtrack(i - 1, j, index + 1, board, word) ||
                backtrack(i, j + 1, index + 1, board, word) ||
                backtrack(i, j - 1, index + 1, board, word);
        board[i][j] = temp;
        return ans;
    }


    public static void main (String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        System.out.println(ws.exist(board, word));
    }
}
