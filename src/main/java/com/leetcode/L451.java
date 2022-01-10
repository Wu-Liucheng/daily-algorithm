package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集
 * 示例
 * 输入：nums=[1,2,3]
 * 输出：[ [3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]
 */
public class L451 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,};
        System.out.println(allSubSet(nums));
    }

    private static List<List<Integer>> allSubSet(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list,List<Integer> temp,int[] nums,int start){
        list.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(list,temp,nums,i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
