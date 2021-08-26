package com.leetcode;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */
public class L478 {


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E', 'E'},
                {'S', 'F', 'C', 'S', 'S'},
                {'A', 'D', 'E', 'E', 'F'},
                {'K', 'M', 'S', 'D', 'M'},
                {'W', 'U', 'D', 'I', 'B'},
        };
        String word = "ECFDMSDESECBASAKWUDIBMFSE";
        //String word = "ECCEESFMBIDUWKASA";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, flag, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backtrack(char[][] board, boolean flag[][], String word, int i, int j, int wordIndex) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || wordIndex < 0 || wordIndex >= word.length()) {
            return false;
        }
        if (board[i][j] == word.charAt(wordIndex) && !flag[i][j]) {
            if (wordIndex == word.length() - 1) {
                return true;
            } else {
                flag[i][j] = true;
                boolean ret = backtrack(board, flag, word, i + 1, j, wordIndex + 1) ||
                        backtrack(board, flag, word, i - 1, j, wordIndex + 1) ||
                        backtrack(board, flag, word, i, j + 1, wordIndex + 1) ||
                        backtrack(board, flag, word, i, j - 1, wordIndex + 1);
                flag[i][j] = false;
                return ret;
            }
        }
        return false;
    }

}
