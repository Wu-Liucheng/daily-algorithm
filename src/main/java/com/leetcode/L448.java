package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数n和k，返回1...n中所有可能的k个数的组合
 * <p>
 * 示例
 * <p>
 * 输入 n = 4, k = 2
 * 输出[
 * [ 2 , 4 ] ,
 * [ 3 , 4 ] ,
 * [ 2 , 3 ] ,
 * [ 1 , 2 ] ,
 * [ 1 , 3 ] ,
 * [ 1 , 4 ] ,
 * ]
 */
public class L448 {

    final static int n = 4;

    final static int k = 2;

    public static void main(String[] args) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrace(ret, 1, new ArrayList<>());
        System.out.println(ret);
    }

    private static void backtrace(List<List<Integer>> ret,
                                  int index,
                                  List<Integer> temp) {
        if (temp.size() == k) {
            ret.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.add(i);
            backtrace(ret, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
