package com.pipickeke.algrithm.code2024.month12.week3;


/**
 * 题目：1734. 解码异或后的排列
 *
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 */
public class Decode_XORed_Permutation {

    private int[] decode(int[] encoded){
        int N = encoded.length+1;
        int[] ans = new int[N];

        int a = 0;
        for (int i = 0; i < N-1; i+=2) {
            a ^= encoded[i];
        }
        int b = 0;
        for (int i = 1; i <= N; i++) {
            b ^= i;
        }

        ans[N-1] = a ^ b;
        for (int i = N-2; i >= 0; i--) {
            ans[i] = ans[i+1] ^ encoded[i];
        }
        return ans;
    }
}
