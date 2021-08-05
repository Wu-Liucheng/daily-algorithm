package com.interview;

/**
 * @author wlc
 * @datetime 2021/7/12 3:24 下午
 * @description
 */

/*
数组中占比超过一半的元素称之为主要元素。给你一个整数数组，找出其中的主要元素。若没有，返回-1。请设计时间复杂度为O(N)、空间复杂度为O(1)的解决方案。

示例 1：
输入：[1,2,5,9,5,9,5,5,5]
输出：5
 */
public class L17_10 {
    public static void main(String[] args) {

        int[] array = new int[]{1,2,5,9,5,9,5};
        System.out.println(function(array));

    }

    static int function(int[] a){
        if(a == null || a.length == 0){
            return -1;
        }
        int count = 1;
        int major = a[0];
        for(int i = 1; i < a.length; i++){
            if(a[i] == major){
                count = count + 1;
            }else {
                count = count - 1;
                if(count < 0){
                    major = a[i];
                    count = 1;
                }
            }
        }
        int r = 0;
        for (int i = 0; i < a.length; i++) {
            if(major == a[i]){
                r = r + 1;
            }
        }
        if(r > a.length / 2){
            return major;
        }else {
            return -1;
        }
    }
}
