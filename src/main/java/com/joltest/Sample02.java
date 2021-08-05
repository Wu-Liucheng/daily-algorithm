package com.joltest;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author wlc
 * @datetime 2021/6/30 4:59 下午
 * @description
 */
public class Sample02 {

    /*
     * This is the more advanced field layout example.
     *
     * Because the underlying hardware platform often requires aligned accesses
     * to maintain the performance and correctness, it is expected the fields
     * are aligned by their size. For booleans it does not mean anything, but
     * for longs it's different. In this example, we can see the long field
     * is indeed aligned for 8 bytes, sometimes making the gap after the
     * object header.
     */
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(A.class).toPrintable());
    }

    public static class A{
        long f;
    }
}
