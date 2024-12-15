package com.pipickeke.algrithm.code2024.month12.week2;

import java.util.Arrays;


/**
 * 题目：找到两个数组的前缀公共数组
 *
 * 给你两个下标从 0 开始长度为 n 的整数排列 A 和 B 。
 *
 * A 和 B 的 前缀公共数组 定义为数组 C ，其中 C[i]
 * 是数组 A 和 B 到下标为 i 之前公共元素的数目。
 *
 * 请你返回 A 和 B 的 前缀公共数组 。
 *
 * 如果一个长度为 n 的数组包含 1 到 n 的元素恰好一次，我们称这个数组是一个长度为 n 的 排列 。
 *
 */
public class Find_the_Prefix_Common_Array_of_Two_Arrays {

    public static void main(String[] args) {
        Find_the_Prefix_Common_Array_of_Two_Arrays bean = new Find_the_Prefix_Common_Array_of_Two_Arrays();
        int[] A = {1,3,2,4};
        int[] B = {3,1,2,4};
        System.out.println(Arrays.toString(bean.findThePrefixCommonArray(A, B)));
    }

    private int[] findThePrefixCommonArray(int[] A, int[] B){

        long recordA = 0;
        long recordB = 0;
        int[] ans = new int[A.length];

        for (int i = 0; i < ans.length; i++) {
            recordA |= 1L << A[i];
            recordB |= 1L << B[i];
            ans[i] = Long.bitCount(recordA & recordB);
        }
        return ans;
    }

    private int numBit(int num){
        int ans = 0;
        while (num != 0){
            ans += (num & 1) == 1 ? 1 : 0;
            num >>=1;
        }
        return ans;
    }
}
