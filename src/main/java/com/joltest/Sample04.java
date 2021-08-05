package com.joltest;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author wlc
 * @datetime 2021/6/30 5:06 下午
 * @description
 */
public class Sample04 {

    /*
     * This is the example how VM lays out the fields in the hierarchy.
     *
     * The important invariant for JVM to maintain is laying out the
     * accessible fields at the same offsets regardless of the class
     * the field is being accessed through. That is, for classes B and C
     * below the field A.a should reside on the same offset. This prompts
     * VM to lay out the superclass fields first.
     */
    public static void main(String[] args) {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(C.class).toPrintable());
    }

    public static class A {
        int a;
    }

    public static class B extends A {
        int b;
    }

    public static class C extends B {
        int c;
    }
}
