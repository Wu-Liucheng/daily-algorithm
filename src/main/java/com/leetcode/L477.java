package com.leetcode;

/**
 * @author wlc
 * @datetime 2021/5/31 8:33 下午
 * @description
 */

/**
 * 一个有名的按摩师会收到源源不断的预约请求， 每个预约都可以选择接或不接。在每次
 * 预约服务之间要有休息时间， 因此她不能接受相邻的预约。给定一个预约请求序列， 替
 * 按摩师找到最优的预约集合（ 总预约时间最长） ， 返回总的分钟数。
 * 示例 1 ：
 * 输入： [ 1 , 2 , 3 , 1 ]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约， 总时长 = 1 + 3 = 4 。
 * 示例 2 ：
 * 输入： [ 2 , 7 , 9 , 3 , 1 ]
 * 输出： 1 2
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约， 总时长 = 2 + 9 + 1 = 1 2 。
 * 示例 3 ：
 * 输入： [ 2 , 1 , 4 , 5 , 3 , 1 , 1 , 3 ]
 * 输出： 1 2
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约， 总时长 = 2 + 4 + 3 + 3
 * = 1 2 。
 */
public class L477 {

    public static void main(String[] args) {
        int[] array = new int[]{2 , 7 , 9 , 3 , 1};
        System.out.println(max(array));
    }

    private static int iter(int[] array,int currentIndex,int sum){
        if(currentIndex >= array.length){
            return sum;
        }
        return Math.max(iter(array,currentIndex+1,sum),iter(array,currentIndex+2,sum+array[currentIndex]));
    }

    private static int max(int[] array){
        return iter(array,0,0);
    }
}
