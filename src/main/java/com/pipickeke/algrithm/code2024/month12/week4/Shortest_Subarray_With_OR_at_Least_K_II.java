package com.pipickeke.algrithm.code2024.month12.week4;


/**
 * 题目：3097. 或值至少为 K 的最短子数组 II
 * 标签：LogTrick
 *
 * 给你一个 非负 整数数组 nums 和一个整数 k 。
 *
 * 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
 *
 * 请你返回 nums 中 最短特别非空
 * 子数组
 * 的长度，如果特别子数组不存在，那么返回 -1 。
 *
 */

public class Shortest_Subarray_With_OR_at_Least_K_II {


    private int minimumSubarrayLength(int[] nums, int k){

        int N = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int x = nums[i];

            ans = Math.min(ans, x >= k ? 1 : Integer.MAX_VALUE);

            for (int j = i-1; j >= 0 && (nums[j] | x) != nums[j]; j--) {
                nums[j] |= x;
                if (nums[j] >= k){
                    ans = Math.min(ans, i-j+1);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans ;
    }
}
