package com.pipickeke.algrithm.code2025.month02.week1;

import java.util.Arrays;

/**
 * 题目：53. 最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 *
 * 子数组
 * 是数组中的一个连续部分。
 *
 */

public class Maximum_Subarray {

    public static void main(String[] args) {
        Maximum_Subarray bean = new Maximum_Subarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(bean.maxSubArray_2(nums));
    }


    private int maxSubArray(int[] nums){
        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = nums[0];

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i-1],0) + nums[i];
            res = Math.max(res, dp[i]);
        }

        return res;
    }


    private int maxSubArray_2(int[] nums){
        int N = nums.length;
        int[] sumarr = new int[N+1];
        sumarr[0] = 0;

        int minval = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            sumarr[i] = sumarr[i-1] + nums[i-1];
            res = Math.max(res, sumarr[i] - minval);
            minval = Math.min(minval, sumarr[i]);
        }
        return res;
    }














    }
