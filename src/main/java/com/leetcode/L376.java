package com.leetcode;

/**
 * @author wlc
 * @datetime 2021/6/9 1:07 下午
 * @description
 */

/**
 * 给你两个单词 word1 和 word2 ， 请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 示例 1：
 * 输入： word1 = "horse" , word2 = "ros"
 * 输出： 3
 * 解释：
 * horse - > rorse ( 将 'h' 替换为 'r' )
 * rorse - > rose ( 删除 'r' )
 * rose - > ros ( 删除 'e' )
 * 总有共3 步
 *
 * 示例 2：
 * 输入： word1 = "intention" , word2 = "execution "
 * 输出： 5
 * 解释：
 * intention - > inention ( 删除 't' )
 * inention - > enention ( 将 'i' 替换为 'e' )
 * enention - > exention ( 将 'n' 替换为 'x' )
 * exention - > exection ( 将 'n' 替换为 'c' )
 * exection - > execution ( 插入 'u' )
 * 总有共5步
 */
public class L376 {
    public static void main(String[] args) {
        String words1 = "intention";
        String words2 = "execution";
        System.out.println(minSteps(words1,words2));
    }

    public static int minSteps(String words1,String words2){
        int length1 = words1.length();
        int length2 = words2.length();
        if(length1 * length2 == 0){
            return length1 + length2;
        }
        int[][] dp = new int[length1 + 1][length2 + 1];
        for(int i = 0; i <= length1; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j <= length2; j++) {
            dp[0][j] = j;
        }
        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(words1.charAt(i - 1) == words2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[length1][length2];
    }

}
