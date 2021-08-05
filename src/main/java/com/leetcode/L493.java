package com.leetcode;

/*
  @author wlc
 * @datetime 2021/5/25 1:26 下午
 * @description
 */

/**
 * 在上次打劫完一条街道之后和一圈房屋后， 小偷又发现了一个新的可行窃的地区。这个
 * 地区只有一个入口， 我们称之为“ 根” 。除了“ 根” 之外， 每栋房子有且只有一个“ 父“ 房子
 * 与之相连。一番侦察之后， 聪明的小偷意识到“ 这个地方的所有房屋的排列类似于一棵二
 * 叉树” 。如果两个直接相连的房子在同一天晚上被打劫， 房屋将自动报警。
 * 计算在不触动警报的情况下， 小偷一晚能够盗取的最高金额。
 */
public class L493 {

    public static void main(String[] args) {
        Integer[] houses = new Integer[]{3, 4, 5, 1, 3, null, 1};
        System.out.println(award(houses, 0));
        System.out.println(award(houses));
    }

    //递归版本
    private static int award(Integer[] houses, int currentRootIndex) {
        if (currentRootIndex >= houses.length || houses[currentRootIndex] == null) {
            return 0;
        }
        return Math.max(houses[currentRootIndex] +
                        award(houses, 2 * (2 * currentRootIndex + 1) + 1) +
                        award(houses, 2 * (2 * currentRootIndex + 1) + 2) +
                        award(houses, 2 * (2 * currentRootIndex + 2) + 1) +
                        award(houses, 2 * (2 * currentRootIndex + 2) + 2)
                        ,
                        award(houses, 2 * currentRootIndex + 1) +
                        award(houses, 2 * currentRootIndex + 2));
    }
    //非递归版本
    private static int award(Integer[] houses){
        int[] dp= new int[]{};

        return 0;
    }
}
