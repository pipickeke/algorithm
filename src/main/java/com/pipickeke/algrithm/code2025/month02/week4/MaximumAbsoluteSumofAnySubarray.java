package com.pipickeke.algrithm.code2025.month02.week4;

/**
 * 题目：1749. 任意子数组和的绝对值的最大值
 *
 * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr]
 * 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 *
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 *
 * abs(x) 定义如下：
 *
 * 如果 x 是负整数，那么 abs(x) = -x 。
 * 如果 x 是非负整数，那么 abs(x) = x 。
 *
 */

public class MaximumAbsoluteSumofAnySubarray {


    private int maxAbsoluteSum(int[] nums){
        int n = nums.length;
        int fmin = 0, fmax = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            fmax = Math.max(fmax,0) + nums[i];
            fmin = Math.min(fmin,0) + nums[i];
            ans = Math.max(ans, Math.max(fmax, -fmin));
        }
        return ans;
    }




}
