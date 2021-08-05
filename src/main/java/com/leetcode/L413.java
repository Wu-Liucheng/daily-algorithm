package com.leetcode;

/**
 * @author wlc
 * @datetime 2021/6/1 4:08 下午
 * @description
 */

/**
 * 动态规划求最长上升子序列
 * H o p e i s l i k e t h e s u n , a s w e j o u r n e y t o w a r d i t , c a s t s t h e
 * s h a d o w o f o u r b u r d e n b e h i n d u s .
 * 希望有如太阳， 当我们向它行进时， 便把我们负担的阴影投在身后。
 *
 * 给定一个无序的整数数组， 找到其中最长上升子序列的长度。
 * 示例:
 * 输入: [ 1 0 , 9 , 2 , 5 , 3 , 7 , 1 0 1 , 1 8 ]
 * 输出: 4
 * 解释: 最长的上升子序列是 [ 2 , 3 , 7 , 1 0 1 ] ， 它的长度是 4 。
 */
public class L413 {
    public static void main(String[] args) {
        int[] array = new int[]{ 10 , 9 , 2 , 5 , 3 , 7 , 101 , 18 };
        System.out.println(maxLength(array));
    }

    private static int maxLength(int[] array){
        int ret = 0;
        for(int i = 0; i < array.length; i++){
            int temp = 1;
            int jumpIndex = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j]>array[jumpIndex]){
                    temp++;
                    jumpIndex = j;
                }
            }
            ret = Math.max(ret,temp);
        }
        return ret;
    }
}
