package com.leetcode;

/**
 * @author wlc
 * @datetime 2021/6/1 4:19 下午
 * @description
 */

/**
 * 动态规划和递归求不同路径 II
 * I f y o u ' r e n o t s a t i s f i e d w i t h t h e l i f e y o u ' r e l i v i n g , d o n ' t
 * j u s t c o m p l a i n . D o s o m e t h i n g a b o u t i t .
 * 对于现况的不满， 你不能只是抱怨， 而是要有勇气作出改变。
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （ 起始点在下图中标记为“ S t a r t ” ） 。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（ 在下图中标记
 * 为“ F i n i s h ” ） 。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 输入:
 * [
 * [ 0 , 0 , 0 ] ,
 * [ 0 , 1 , 0 ] ,
 * [ 0 , 0 , 0 ]
 * ]
 * 输出: 2
 * 解释:
 * 3 x 3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1 . 向右 - > 向右 - > 向下 - > 向下
 * 2 . 向下 - > 向下 - > 向右 - > 向右
 */
public class L411 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        };
        System.out.println(diffPathNum(matrix));
    }

    private static int diffPathNum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        //第一列初始化
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                for (; i < m; i++) {
                    dp[i][0] = 0;
                }
                break;
            }
        }
        //第一列初始化
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                for (; j < n; j++) {
                    dp[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
