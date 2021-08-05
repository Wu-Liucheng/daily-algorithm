package com.others;

/**
 * @author wlc
 * @datetime 2021/5/28 1:28 下午
 * @description
 */

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] array = new int[]{7,5,4,3,2,1,0,4};
        System.out.println(canArrive(array));
    }

    private static boolean canArriveIter(int[] array,int currentIndex){
        if(currentIndex >= array.length - 1){
            return true;
        }
        if(array[currentIndex] == 0){
            return false;
        }
        boolean result = false;
        for(int i = 1; i <= array[currentIndex]; i++){
            result = result || canArriveIter(array,currentIndex + i);
        }
        return result;
    }

    private static boolean canArrive(int[] array){
        return canArriveIter(array,0);
    }
}
