package com.leetcode;

/**
 * 在柠檬水摊山，每一杯柠檬水的售价为5美元。
 * 顾客排队购买你的产品，（按账单bills支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你支付5美元、10美元或20美元。
 * 你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付5美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零返回true，否则返回false
 */
public class L489 {

    public static void main(String[] args) {
        int[] bills = new int[]{5, 5, 10, 10, 5};
        System.out.println(result(bills));
    }

    private static boolean result(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                } else {
                    five--;
                    ten++;
                }
            } else {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five = five - 3;
                }
                if (five < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
