package com.pipickeke.algrithm.code2024.month11.week4;

import java.util.Arrays;

/**
 *  题目：颠倒二进制位
 *  颠倒给定的 32 位无符号整数的二进制位。
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，
 * 输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
 * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。
 * 因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 *
 * 思路：
 *  从低位到高位，依次获取低位的1，然后放到对应的 31-i 位置，实现翻转
 *  同时，入参每次向右无符号移动 >>>1，主要是考虑到对负数的处理
 */
public class Reverse_Bits {

    public static void main(String[] args) {

        int num = Integer.MIN_VALUE;
        Reverse_Bits bean = new Reverse_Bits();
        bean.get32(num);

        int a = num >>1;
        int b = num >>>1;
        bean.get32(a);
        bean.get32(b);
    }

    private void get32(int n){
        for (int i = 31; i >= 0; i--) {
            System.out.print((n & (1 <<i)) == 0 ? 0 : 1);
        }
        System.out.println();
    }

    private int reverseBits(int n){
        int ans = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            ans |= ((n & 1) << (31 - i));
            n >>>=1;
        }
        return ans;
    }

    private int bit(int n){
        int ans = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            ans |= ((n &1) << (31 -i));
            n >>>=1;
        }
        return ans;
    }
}
