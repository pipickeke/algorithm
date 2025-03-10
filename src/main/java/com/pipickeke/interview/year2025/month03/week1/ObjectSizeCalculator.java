package com.pipickeke.interview.year2025.month03.week1;


import org.openjdk.jol.info.ClassLayout;

import java.lang.instrument.Instrumentation;

/**
 *
 * 问题：
 *      一个java对象的内存占用是多少？
 *
 */

public class ObjectSizeCalculator {

    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst){
        instrumentation = inst;
    }

    public static long getObjectSize(Object obj){
        if (instrumentation == null){
            throw new IllegalStateException("Instrumentation is not initialized.");
        }
        return instrumentation.getObjectSize(obj);
    }

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(Person.class).toPrintable());
    }


}

class Person{
    int age; //4B
    boolean male; //1B, 需要填充3B对齐
    double height; //8B
    String name; //4B
}
