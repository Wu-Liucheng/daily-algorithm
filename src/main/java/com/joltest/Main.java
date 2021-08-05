package com.joltest;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author wlc
 * @datetime 2021/6/30 1:48 下午
 * @description
 */

public class Main {

    public static void main(String[] args) {

        var o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
