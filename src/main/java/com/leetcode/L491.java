package com.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wlc
 * @datetime 2021/8/5 4:52 下午
 * @description
 */
/*
给定一个数字字符串S ， 比如S = "123456579" ， 我们可以将它分成斐波那契式的序列
[123,456,579]

形式上， 斐波那契式序列是一个非负整数列表F， 且满足：
0<=F[i]<=2^31-1，（ 也就是说，每个整数都符合32位有符号整数类型）；
F.length>=3；
对于所有的0<=i<F.length-2，都有F[i]+F[i+1]=F[i+2]成立。
另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块
是数字0本身。
返回从S拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回[]。
示例1：
输入："123456579"
输出：[123,456,579]
 */
public class L491 {

    public static void main(String[] args) {
        String s = "12345657910351614";
        List<BigInteger> res = new ArrayList<>();
        backtrack(s,res,0);
        System.out.println(res);
    }

    public static boolean backtrack(String digit,List<BigInteger> res,int index){
        if(index == digit.length() && res.size() >= 3){
            return true;
        }
        for(int i = index; i < digit.length(); i++){
            if(digit.charAt(index) == '0' && i > index){
                break;
            }
            BigInteger num = new BigInteger(digit.substring(index, i + 1));
            int size = res.size();
            if(size >= 2 && num.compareTo(res.get(size - 1).add(res.get(size - 2))) > 0){
                break;
            }
            if(size <= 1 || num.compareTo(res.get(size - 1).add(res.get(size - 2))) == 0){
                res.add(num);
                if(backtrack(digit, res, i + 1)){
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
