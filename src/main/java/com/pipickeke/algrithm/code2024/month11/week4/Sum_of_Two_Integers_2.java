package com.pipickeke.algrithm.code2024.month11.week4;

/**
 *  题目：两整数之和
 *  给你两个整数 a 和 b ，不使用 运算符 + 和
 *  - ，计算并返回两整数之和。
 *
 */
public class Sum_of_Two_Integers_2 {

    public static void main(String[] args) {

    }

    private int getSum(int a, int b){
        while ( (a & b) != 0 ){
            int tmp = a;
            a = a^b;
            b = ( tmp & b) <<1;
        }
        return a ^ b;
    }
}
