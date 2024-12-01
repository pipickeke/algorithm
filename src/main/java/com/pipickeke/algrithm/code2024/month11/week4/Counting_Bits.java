package com.pipickeke.algrithm.code2024.month11.week4;

import java.util.Arrays;

/**
 *  题目：比特位计数
 *  给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，
 *  计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 */
public class Counting_Bits {

    public static void main(String[] args) {
        Counting_Bits bean = new Counting_Bits();
        System.out.println(Arrays.toString(bean.countBits(5)));
    }

    private int[] countBits(int n){
        int N = n+1;
        int[] arr = new int[N];
        for (int i = 0; i <= n; i++) {
            int cur = i;
            int cnt = 0;
            while (cur != 0){
                cnt += (cur &1) == 0 ? 0 : 1;
                cur >>>=1;
            }
            arr[i] = cnt;
        }
        return arr;
    }
}
