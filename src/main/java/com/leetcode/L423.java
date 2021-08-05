package com.leetcode;

/**
 * @author wlc
 * @datetime 2021/6/1 7:41 上午
 * @description
 */

/**
 * 给定一个包含非负整数的 m x n 网格， 请找出一条从左上角到右下角的路径， 使得路径
 * 上的数字总和为最小。
 * 说明： 每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 * [ 1 , 3 , 1 ] ,
 * [ 1 , 5 , 1 ] ,
 * [ 4 , 2 , 1 ]
 * ]
 * 输出: 7
 * 解释: 因为路径 1 → 3 → 1 → 1 → 1 的总和最小。
 */
public class L423 {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1 , 3 , 1},
                {1 , 5 , 1},
                {4 , 2 , 1}
        };
        System.out.println(iter(array,0,0,0));
    }

    private static int iter(int[][] array,int x,int y,int sum){
        if(x == array.length - 1){
            for(int i = y; i < array[x].length; i++){
                sum += array[x][i];
            }
            return sum;
        }
        if(y == array[x].length - 1){
            for (int i = x; i < array.length; i++){
                sum += array[i][y];
            }
            return sum;
        }
        return Math.min(
                iter(array,x,y+1,sum+array[x][y]),
                iter(array,x+1,y,sum+array[x][y])
        );
    }

}
