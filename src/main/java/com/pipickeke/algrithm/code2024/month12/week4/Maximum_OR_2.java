package com.pipickeke.algrithm.code2024.month12.week4;


/**
 * 题目：2680. 最大或值
 *
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k 。
 * 每一次操作中，你可以选择一个数并将它乘 2 。
 *
 * 你最多可以进行 k 次操作，请你返回 nums[0] | nums[1] | ... | nums[n - 1] 的最大值。
 *
 * a | b 表示两个整数 a 和 b 的 按位或 运算。
 *
 *
 */
public class Maximum_OR_2 {

    private long maximumOr(int[] nums, int k){
        int N = nums.length;
        int[] suf = new int[N+1];
        for (int i = N-2; i >= 0; i--) {
            suf[i] = suf[i+1] | nums[i+1];
        }

        int pre = 0;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, pre | (long) nums[i] << k | suf[i] );
            pre |= nums[i];
        }
        return ans;
    }
}
