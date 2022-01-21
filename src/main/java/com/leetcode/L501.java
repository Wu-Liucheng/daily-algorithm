package com.leetcode;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干j，都有一个尺寸s[j]。如果s[j]>=g[i]，我们可以将这个饼干j分配给孩子i，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大值
 * 示例
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释: 你有三个孩子和两块饼干，3个孩子的胃口值分别是1，2，3。虽然你只有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 */
public class L501 {

    public static void main(String[] args) {
        int[] g = new int[]{1, 2};
        int[] s = new int[]{1, 2, 3};
        System.out.println(fun(g, s));
    }

    private static int fun(int[] g, int[] s) {
        int ret = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int limit = Math.min(g.length, s.length);
        for (int i = 0, j = 0; i < limit && j < limit; ) {
            if (s[j] >= g[i]) {
                ret++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return ret;
    }
}
