package com.pipickeke.algrithm.code2024.month12.week2;


/**
 * 题目：奇偶位数
 *
 * 给你一个 正 整数 n 。
 *
 * 用 even 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的偶数下标的个数。
 *
 * 用 odd 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的奇数下标的个数。
 *
 * 返回整数数组 answer ，其中 answer = [even, odd] 。
 *
 */
public class Number_of_Even_and_Odd_Bits {

    private int[] evenOddBit(int n){
        int[] ans = new int[2];

        int i = 0;
        while (n != 0){
            ans[i%2] += (n&1) == 1 ? 1 : 0;
            n >>=1;
        }
        return ans;
    }
}
