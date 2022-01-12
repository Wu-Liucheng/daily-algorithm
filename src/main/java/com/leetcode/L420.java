package com.leetcode;

import java.util.Objects;

/**
 * 请设计一个函数， 用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始， 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格， 那么该路径不能再次进入该格子。
 * 例如， 在下面的3 × 4 的矩阵中包含一条字符串“ b f c e ” 的路径 。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“ a b f b ” 的路径， 因为字符串的第一个字符b 占据了矩阵中的第一行第二个格子之后， 路径不能再次进入这个格子。
 * <p>
 * 示例 1 ：
 * 输入：
 * board = [["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]],
 * word ="ABCCED"
 * 输出： true
 * 示例 2 ：
 * 输入： board = [["a","b"],
 * ["c","d"]],
 * word = "abcd"
 * 输出： false
 */
public class L420 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        fun(board);
        System.out.println(ret);
    }

    static String word = "ABCCE";
    static boolean ret = false;

    private static void fun(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] flag = new boolean[board.length][board[i].length];
                backtrace(board, i, j, flag, "");
            }
        }
    }

    private static void backtrace(char[][] board, int x, int y, boolean[][] flag, String current) {
        if (ret) {
            return;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[x].length
                || flag[x][y]) {
            if (Objects.equals(current, word)) {
                ret = true;
            }
            return;
        }
        flag[x][y] = true;
        backtrace(board, x + 1, y, flag, current + board[x][y]);
        backtrace(board, x - 1, y, flag, current + board[x][y]);
        backtrace(board, x, y + 1, flag, current + board[x][y]);
        backtrace(board, x, y - 1, flag, current + board[x][y]);
        flag[x][y] = false;
    }
}
