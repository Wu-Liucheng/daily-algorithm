package com.leetcode;

import java.lang.ref.Reference;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用m*n的网格grid进行了标注。每个单元格的整数就表示这一单元格中的黄金数量，如果单元格是空的，那么就是0；
 * 为了使收益最大化，矿工需要按以下规则开采黄金：
 * ·每当矿工进入一个单元，就会收集该单元的所有黄金。
 * ·矿工每次可以从当前位置向上下左右四个方向走。
 * ·每个单元格只能被开采（进入）一次。
 * ·不得开采（进入）黄金数目为0的单元格。
 * ·矿工可以从网格中任意一个有黄金的单元格出发或是停止。
 * <p>
 * 示例：
 * 输入 grid = [ [ 0 , 6 , 0 ] , [ 5 , 8 , 7 ] , [ 0 , 9 , 0 ] ]
 * 输出 24
 * 解释
 * [ [ 0 , 6 , 0 ] ,
 * [ 5 , 8 , 7 ] ,
 * [ 0 , 9 , 0 ] ]
 * 一种收集最多的黄金路线是9->8->7
 */
public class L446 {

    public static void main(String[] args) {
//        int[][] grid = new int[][]{
//                {0, 6, 0},
//                {5, 8, 7},
//                {0, 9, 0}};
        int[][] grid = new int[][]{
                {1, 0, 7},
                {2, 0, 6},
                {3, 4, 5},
                {0, 3, 0},
                {9, 0, 20}
        };
        fun(grid);
        System.out.println(max);
    }

    static int max = 0;

    private static void fun(int[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                boolean[][] flag = new boolean[grid.length][grid[0].length];
                backtrace(grid, i, j, flag, 0);
            }
        }
    }

    private static void backtrace(int[][] grid, int xIndex, int yIndex, boolean[][] flag, int current) {
        if (xIndex < 0 || yIndex < 0 || xIndex >= grid.length || yIndex >= grid[xIndex].length
                || grid[xIndex][yIndex] == 0
                || flag[xIndex][yIndex]) {
            max = Math.max(current, max);
            return;
        }
        flag[xIndex][yIndex] = true;
        backtrace(grid, xIndex + 1, yIndex, flag, current + grid[xIndex][yIndex]);
        backtrace(grid, xIndex - 1, yIndex, flag, current + grid[xIndex][yIndex]);
        backtrace(grid, xIndex, yIndex + 1, flag, current + grid[xIndex][yIndex]);
        backtrace(grid, xIndex, yIndex - 1, flag, current + grid[xIndex][yIndex]);
        flag[xIndex][yIndex] = false;
    }

}
