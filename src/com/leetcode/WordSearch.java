package com.leetcode;

// 79#, Medium
public class WordSearch {
    public boolean exist (char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
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
        if (word.length() == index) return true;
        if (i < 0 || i >= board.length ||
                j < 0 || j >= board[0].length ||
                board[i][j] != word.charAt(index))
            return false;
        char c = board[i][j];
        board[i][j] = '*'; // 标记，表示已使用过，不能再重复
        boolean ans;
        ans = backtrack(i + 1, j, index + 1, board, word)
                || backtrack(i - 1, j, index + 1, board, word)
                || backtrack(i, j + 1, index + 1, board, word)
                || backtrack(i, j - 1, index + 1, board, word);
        board[i][j] = c; // 用完之后还要换回来，方便别的元素使用
        return ans;
    }

    public static void main (String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        System.out.println(ws.exist(board, word));
    }
}
