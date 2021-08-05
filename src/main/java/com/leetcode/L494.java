package com.leetcode;

/**
 * @author wlc
 * @datetime 2021/6/9 9:42 上午
 * @description
 */

/**
 * We went through a lot, but we stay together.
 * 给你一个整数数组nums和一个整数target。
 * <p>
 * 向数组中的每个整数前添加'+'或'-'，然后串联起所有整数，可以构造一个表达式 ：
 * 例如，nums=[2,1]，可以在2之前添加'+'，在1之前添加'-'，然后串联起来得到表达式"+2-1"。
 * 返回可以通过上述方法构造的、运算结果等于target的不同表达式的数目。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * <p>
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 */
public class L494 {

    static int count = 0;

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 1, 1};
        int targetValue = 3;
        dfs(array,targetValue,0,0);
        System.out.println(count);
    }

    private static void dfs(int[] nums, int target, int sum, int index) {
        //判断从根节点到当前叶子节点这条路径是否走完了
        if (index == nums.length) {
            //如果当前累加值等于target，说明找到了一条符号条件的表达式
            if (target == sum)
                count++;
            return;
        }
        //左子树数负数，要减去
        dfs(nums, target, sum - nums[index], index + 1);
        //右子树是正数，要加上
        dfs(nums, target, sum + nums[index], index + 1);
    }
}
