package com.leetcode;

/**
 * @author wlc
 * @datetime 2021/5/25 3:52 下午
 * @description
 */

/**
 * 给定一个数组， 它的第i 个元素是一支给定股票第i 天的价格。
 * 如果你最多只允许完成一笔交易（ 即买入和卖出一支股票一次） ， 设计一个算法来计算
 * 你所能获取的最大利润。
 * 注意： 你不能在买入股票前卖出股票。
 *
 * 输入: [ 7 , 1 , 5 , 3 , 6 , 4 ]
 * 输出: 5
 * 解释: 在第 2 天（ 股票价格 = 1 ） 的时候买入， 在第 5 天（ 股票价格 = 6 ） 的时候卖
 * 出， 最大利润 = 6 - 1 = 5 。
 * 注意利润不能是 7 - 1 = 6 , 因为卖出价格需要大于买入价格； 同时， 你不能在买入
 * 前卖出股票。
 */
public class L490 {
    public static void main(String[] args) {
        int[] market = new int[]{7 , 1 , 5 , 3 , 6 , 4};
        int max = 0;
        for(int i = 0; i < market.length; i++){
            int m = 0;
            for(int j = i + 1; j < market.length; j++){
                int k = market[j] - market[i];
                if(m < k){
                    m = k;
                }
            }
            if(max < m){
                max = m;
            }
        }
        System.out.println(max);
    }
}
