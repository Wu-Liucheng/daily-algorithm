package com.leetcode;

/**
 * 二叉树节点
 */
public class Node {

    int value;//值

    Node left;//左节点

    Node right;//右节点

    Node(int value) {
        this.value = value;
    }

    Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
