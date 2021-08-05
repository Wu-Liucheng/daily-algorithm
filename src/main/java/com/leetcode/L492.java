package com.leetcode;

/*
  @author wlc
 * @datetime 2021/5/25 3:19 下午
 * @description
 */

/**
 * 给定一个数组， 它的第i 个元素是一支给定股票第i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（ 多次买
 * 卖一支股票） 。
 * 注意： 你不能同时参与多笔交易（ 你必须在再次购买前出售掉之前的股票） 。
 * <p>
 * 输入: [ 7 , 1 , 5 , 3 , 6 , 4 ]
 * 输出: 7
 * 解释: 在第 2 天（ 股票价格 = 1 ） 的时候买入， 在第 3 天（ 股票价格 = 5 ） 的时候卖
 * 出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 随后， 在第 4 天（ 股票价格 = 3 ） 的时候买入， 在第 5 天（ 股票价格 = 6 ） 的时
 * 候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * <p>
 * 输入: [ 1 , 2 , 3 , 4 , 5 ]
 * 输出: 4
 * 解释: 在第 1 天（ 股票价格 = 1 ） 的时候买入， 在第 5 天 （ 股票价格 = 5 ） 的时候卖
 * 出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票， 之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易， 你必须在再次购买前出售掉之前的股票。
 * <p>
 * 输入: [ 7 , 6 , 4 , 3 , 1 ]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0 。
 */
public class L492 {

    public static void main(String[] args) {
        int[] market = new int[]{1, 2, 3, 4, 5,6,7,8,10,3,15};
        System.out.println(earn(market));
        System.out.println(earnGreedy(market));
    }

    //动态规划解决
    private static int earn(int[] market) {
        return earnIter(0, market, 0, 0);
    }

    /**
     * 迭代器
     * @param earnings     赚的赏金数 初始值为0
     * @param market       行情数组 初始值为0
     * @param dayIndex     日期下表
     * @param lastTimesOpt 上次的操作 0-卖出 1-买入 初始值为0
     * @return 赚取的收益
     */
    private static int earnIter(int earnings, int[] market, int dayIndex, int lastTimesOpt) {
        if (dayIndex >= market.length) {
            return earnings;
        }
        if (lastTimesOpt == 0) {
            return Math.max(
                    earnIter(earnings, market, dayIndex + 1, 0),
                    earnIter(earnings - market[dayIndex], market, dayIndex + 1, 1)
            );
        } else {
            return Math.max(
                    earnIter(earnings, market, dayIndex + 1, 1),
                    earnIter(earnings + market[dayIndex], market, dayIndex + 1, 0)
            );
        }
    }

    //贪婪算法？
    private static int earnGreedy(int[] market){
        int ret = 0;
        for(int i = 1; i < market.length; i++){
            int earn = market[i]-market[i-1];
            if(earn > 0){
                ret += earn;
            }
        }
        return ret;
    }
}
