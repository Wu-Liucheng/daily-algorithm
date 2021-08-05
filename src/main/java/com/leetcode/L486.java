package com.leetcode;

/**
 * @author wlc
 * @datetime 2021/5/30 4:56 下午
 * @description
 */

/**
 * 给定一个整数数组n u m s ， 找到一个具有最大和的连续子数组（ 子数组最少包含一个元
 * 素） ， 返回其最大和。
 * 示例:
 * 输入: [ - 2 , 1 , - 3 , 4 , - 1 , 2 , 1 , - 5 , 4 ]
 * 输出: 6
 * 解释: 连续子数组[ 4 , - 1 , 2 , 1 ] 的和最大， 为6 。
 */
public class L486 {

    public static void main(String[] args) {
        int[] array = new int[]{- 2 , 1 , - 3 , 4 , - 1 , 2 , 1 , - 5 , 4};
        System.out.println(fun(array));
    }

    private static int fun(int[] array){
        int ret = 0;
        for(int i = 0; i < array.length; i++){
            int r = 0;
            int temp = 0;
            if(array[i]<0){
                continue;
            }
            for(int j = i + 1; j < array.length; j++){
                for(int k = i; k <= j; k++){
                    r += array[k];
                }
                temp = Math.max(temp,r);
                r = 0;
            }
            ret = Math.max(ret,temp);
        }
        return ret;
    }
}
