package com.leetcode;

/**
 * @author wlc
 * @datetime 2021/5/31 8:47 下午
 * @description
 */

/**
 * 给定一个三角形， 找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点
 * 上。
 * 相邻的结点在这里指的是下标与上一层结点下标相同或者等于一层结点下标+ 1 的两个结
 * 点。
 * 例如， 给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 1 1 （ 即， 2 + 3 + 5 + 1 = 1 1 ） 。
 */
public class L465 {

    public static void main(String[] args) {
        int[][] triangle = new int[][]{
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3},
                {1,2,1,4,1}
        };
        System.out.println(iter(triangle,0,0,0));
    }

    private static int iter(int[][] triangle,int x,int y,int pathSum){
        if(x==triangle.length-1){
            return pathSum+triangle[x][y];
        }
        return Math.min(iter(triangle,x+1,y,pathSum+triangle[x][y]),
                iter(triangle,x+1,y+1,pathSum+triangle[x][y]));
    }
}
