package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从数的根节点开始往下一直到叶节点所经过的节点形成一条路径
 * <p>
 * 示例
 * 给定如下二叉树，以及目标和sum=22，
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * / \     / \
 * 7   2   5   1
 */
public class L442 {

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(2);
        Node n3 = new Node(5);
        Node n4 = new Node(1);
        Node n5 = new Node(11, n1, n2);
        Node n6 = new Node(13);
        Node n7 = new Node(4, n3, n4);
        Node n8 = new Node(4);
        n8.left = n5;
        Node n9 = new Node(8, n6, n7);
        Node root = new Node(5, n8, n9);
        final int target = 22;
        List<List<Integer>> ret = new ArrayList<>();
        backtrace(ret, root, new ArrayList<>(), target);
        System.out.println(ret);
    }

    private static void backtrace(List<List<Integer>> ret,
                                  Node current,
                                  List<Integer> temp,
                                  final int target) {
        temp.add(current.value);
        int sum = sum(temp);
        if (sum > target) {
            temp.remove(temp.size() - 1);
            return;
        }
        if (current.left == null && current.right == null) {
            if (sum == target) {
                ret.add(new ArrayList<>(temp));
            }
            temp.remove(temp.size() - 1);
            return;
        }
        if (current.left != null) {
            backtrace(ret, current.left, temp, target);
        }
        if (current.right != null) {
            backtrace(ret, current.right, temp, target);
        }
        temp.remove(temp.size() - 1);
    }

    private static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum = sum + i;
        }
        return sum;
    }

    private static void query(Node node) {
        if (node == null) {
            return;
        }
        query(node.left);
        System.out.print(node.value + ",");
        query(node.right);
    }
}
