package com.leetcode;

import java.util.ArrayList;
import java.util.List;

//找出所有相加之和为n的k个书的组合。组合中只允许含有1-9的正整数，并且每种组合中不存在重复的数字
//说明：所有数字都是正整数
//解集不能包含重复的组合
//示例：输入k = 3,n=7
//输出[[1,2,4]]
public class L450 {

    final static int k = 3;

    final static int n = 9;

    public static void main(String[] args) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrace(ret, 0, new ArrayList<>(), 1);
        System.out.println(ret);
    }

    private static void backtrace(List<List<Integer>> ret,
                                  int currentSum,
                                  List<Integer> temp,
                                  int start) {
        if (currentSum > n || temp.size() > k) {
            return;
        }
        if (currentSum == n && temp.size() == k) {
            ret.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            backtrace(ret, currentSum + i, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
