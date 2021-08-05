package com.leetcode;

/**
 * @author wlc
 * @datetime 2021/6/8 4:11 下午
 * @description
 */

/**
 * 一个机器人位于一个 m x n 网格的左上角 （ 起始点在下图中标记为“ S t a r t ” ） 。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（ 在下图中标记
 * 为“ F i n i s h ” ） 。
 * 问总共有多少条不同的路径？
 */
public class L409 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        };
        System.out.println(uniquePaths(matrix.length,matrix[0].length));
    }

    public static int uniquePaths(int m,int n){
        int N = m + n - 2;
        double res = 1;
        for (int i = 1; i < m; i++) {
            res = res * (N - (m -1) + i)/i;
        }
        return (int) res;
    }
}
