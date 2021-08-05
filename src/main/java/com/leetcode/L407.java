package com.leetcode;

/**
 * @author wlc
 * @datetime 2021/6/9 12:13 下午
 * @description
 */

/**
 * 给两个整数数组 A 和 B ， 返回两个数组中公共的、长度最长的子数组的长度。
 * 示例：
 * 输入：
 * A : [ 1 , 2 , 3 , 2 , 1 ]
 * B : [ 3 , 2 , 1 , 4 , 7 ]
 * 输出： 3
 * 解释：
 * 长度最长的公共子数组是 [ 3 , 2 , 1 ] 。
 */
public class L407 {

    public static void main(String[] args) {
        int[] a = new int[]{ 1 , 2 , 3 , 2 , 1 };
        int[] b = new int[]{ 3 , 2 , 1 , 4 , 7 };
        System.out.println(maxLength(a,b));
    }


    static int maxLength(int[] a, int[] b){
        int m = a.length;
        int n = b.length;
        int[][] dp = new int[m][n];
        int ret = 0;
        for(int i = 0; i < m; i++){
            if(b[i] == a[0]){
                dp[i][0] = 1;
            }
        }
        for(int j = 0; j < n; j++){
            if(a[j] == b[0]){
                dp[0][j] = 1;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(a[i] == b[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ret = Math.max(ret, dp[i][j]);
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return ret;
    }
}
