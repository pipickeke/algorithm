package com.pipickeke.algrithm.code2025.month02.week1;


/**
 * 题目：53. 最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组
 * 是数组中的一个连续部分。
 *
 */

public class Maximum_Subarray_2 {



    private int maxSubArray(int[] nums){
        int presum = 0;
        int ans = Integer.MIN_VALUE;

        int min = 0;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            presum += nums[i];
            ans = Math.max(ans, presum - min);
            min = Math.min(min, presum);
        }
        return ans;
    }
}
