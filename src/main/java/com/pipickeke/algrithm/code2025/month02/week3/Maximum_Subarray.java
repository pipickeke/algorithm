package com.pipickeke.algrithm.code2025.month02.week3;

/**
 * 题目：53. 最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组
 * （子数组最少包含一个元素），返回其最大和。
 *
 * 子数组
 * 是数组中的一个连续部分。
 *
 */

public class Maximum_Subarray {

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        Maximum_Subarray bean = new Maximum_Subarray();
        System.out.println(bean.maxSubArray_2(nums));
    }

    private int maxSubArray(int[] nums){
        int N = nums.length;
        int[] dp = new int[N+1];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            dp[i+1] = Math.max(dp[i],0) + nums[i];
            res = Math.max(res, dp[i+1]);
        }
        return res;
    }


    private int maxSubArray_2(int[] nums){
        int N = nums.length;
        int presum = 0;
        int min = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            presum += nums[i];
            res = Math.max(res, presum-min);
            min = Math.min(min, presum);
        }
        return res;
    }

}
