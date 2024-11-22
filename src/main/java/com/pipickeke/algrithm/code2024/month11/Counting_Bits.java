package com.pipickeke.algrithm.code2024.month11;

import java.util.Arrays;

/**
 *  题目：比特位计数
 *  给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，
 *  计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 */
public class Counting_Bits {

    public static void main(String[] args) {
        int num = 5;
        System.out.println(Arrays.toString(countBits(num)));
    }

    private static int[] countBits(int num){

        int[] arr = new int[num+1];
        arr[0] = 0;
        for (int i = 1; i <= num; i++) {
            arr[i] = count(i);
        }
        return arr;
    }

    private static int count(int num){
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            ans += (num & (1 << i)) == 0 ? 0 : 1;
        }
        return ans;
    }



}
