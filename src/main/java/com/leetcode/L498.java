package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wlc
 * @datetime 2021/8/4 4:04 下午
 * @description
 */
/*
你有一套活字字模tiles，其中每个字模上都刻有一个字母tiles[i]。返回你可以印出的
非空字母序列的数目。
注意： 本题中，每个活字字模只能使用一次。
示例 1 ：
输入： "AAB"
输出： 8
解释： 可能的序列为 "A","B","AA","AB","BA","AAB","ABA","BAA"。
*/
public class L498 {
    public static void main(String[] args) {
        String title = "AAABBC";
        char[] chars = title.toCharArray();
        Arrays.sort(chars);
        int[] res = new int[1];
        backtrack(res,chars,new boolean[title.length()],title.length(),0);
        System.out.println(res[0]);

    }

    private static void backtrack(int[] res, char[] chars, boolean[] used, int length, int index) {
        //如果没有可以选择的就返回
        if(index == length){
            return;
        }
        //注意 这里的i每次都是从0开始的 不是从index开始
        for (int i = 0; i < length; i++) {
            //一个字符只能选择一次，如果当前字符已经选择了 就不能再选了
            if(used[i]){
                continue;
            }
            //过滤掉重复的结果
            if(i - 1 >= 0 && chars[i] == chars[i-1] && !used[i - 1]){
                continue;
            }
            //选择当前字符，并把他标记为已选择
            used[i] = true;
            //选择一个字符，就多了一种结果
            res[0] ++;
            //下一分支继续递归
            backtrack(res,chars,used,length,index + 1);
            //使用完之后再把它复原
            used[i] = false;
        }
    }
}
