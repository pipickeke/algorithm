package com.pipickeke.algrithm.code2025.month02.week3;

/**
 * 题目：1749. 任意子数组和的绝对值的最大值
 *
 * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 *
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 *
 * abs(x) 定义如下：
 *
 * 如果 x 是负整数，那么 abs(x) = -x 。
 * 如果 x 是非负整数，那么 abs(x) = x 。
 *
 */

public class Maximum_Absolute_Sum_of_Any_Subarray {


    public static void main(String[] args) {
        Maximum_Absolute_Sum_of_Any_Subarray bean = new Maximum_Absolute_Sum_of_Any_Subarray();
        int[] nums = {1,-3,2,3,-4};
        System.out.println(bean.maxAbsoluteSum(nums));
    }


    private int maxAbsoluteSum(int[] nums){
        int N = nums.length;

        int fmin = 0;
        int fmax = 0;

        int ans = 0;
        for (int i = 0; i < N; i++) {
            fmax = Math.max(fmax, 0) + nums[i];
            fmin = Math.min(fmin, 0) + nums[i];
            ans = Math.max(ans, Math.max(fmax, -fmin));
        }

        return ans;
    }


    private int maxAbsoluteSum_2(int[] nums){
        int sum = 0, mx = 0, mn = 0;
        for (int x : nums) {
            sum += x;
            if (sum > mx) mx = sum;
            else if (sum < mn) {
                mn = sum;
            }
        }
        return mx - mn;
    }

}
