package com.pipickeke.algrithm.code2024.month11.week4;

/**
 *  题目：两整数之和
 *  给你两个整数 a 和 b ，不使用 运算符 + 和 -
 *  ，计算并返回两整数之和。
 *
 *  思路：
 *  异或是无进位相加
 *  与 是 进位
 *  每次用异或 计算 无进位相加结果，
 *  在用 与， 然后 <<1，得到进位
 *  二者再 异或，就得出的进位相加结果。
 *  直到 a & b ==0,则停止计算
 */
public class Sum_of_Two_Integers {

    public static void main(String[] args) {

        int a = 1, b=2;
        System.out.println(getSum(a, b));
    }

    private static int getSum(int a, int b){
        while ((a & b) != 0){
            int tmp = a;
            a = a ^ b;
            b = (tmp & b) << 1;
        }
        return a ^ b;
    }
}
