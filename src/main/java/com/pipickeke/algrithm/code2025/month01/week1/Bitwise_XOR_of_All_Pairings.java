package com.pipickeke.algrithm.code2025.month01.week1;


/**
 * 题目：2425. 所有数对的异或和
 *
 * 给你两个下标从 0 开始的数组 nums1 和 nums2 ，两个数组都只包含非负整数。
 * 请你求出另外一个数组 nums3 ，包含 nums1 和 nums2 中 所有数对 的异或和（nums1 中每个整数都跟 nums2 中每个整数 恰好 匹配一次）。
 *
 * 请你返回 nums3 中所有整数的 异或和 。
 *
 */

public class Bitwise_XOR_of_All_Pairings {

    private int xorAllNums(int[] nums1, int[] nums2){

        int M = nums1.length;
        int N = nums2.length;
        int xor1 = nums1[0];
        for (int i = 1; i < M; i++) {
            xor1 ^= nums1[i];
        }

        int xor2 = nums2[0];
        for (int i = 1; i < N; i++) {
            xor2 ^= nums2[i];
        }

        xor1 = N%2 == 0 ? 0 : xor1;
        xor2 = M%2 == 0 ? 0 : xor2;
        return xor1 ^ xor2;
    }
}


/**
 *   num1[0]
 *
 *
 *
 */