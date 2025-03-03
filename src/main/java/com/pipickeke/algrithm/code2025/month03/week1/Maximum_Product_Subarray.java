package com.pipickeke.algrithm.code2025.month03.week1;

import java.util.Arrays;

/**
 * 题目：152. 乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 *
 */

public class Maximum_Product_Subarray {


    private int maxProduct(int[] nums){
        int n = nums.length;
        int[] fmax = new int[n];
        int[] fmin = new int[n];
        fmax[0] = fmin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int x = nums[i];
            fmax[i] = Math.max(x, Math.max(fmax[i-1] * x, fmin[i-1] * x));
            fmin[i] = Math.min(x, Math.min(fmax[i-1] * x, fmin[i-1] * x));
        }
        return Arrays.stream(fmax).max().getAsInt();
    }

    private int maxProduct_2(int[] nums){
        int n = nums.length;
        int fmax = 1, fmin = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int pre = fmax;
            fmax = Math.max(nums[i], Math.max(pre * nums[i], fmin * nums[i]));
            fmin = Math.min(nums[i], Math.min(pre * nums[i], fmin * nums[i]));
            ans = Math.max(ans, fmax);
        }
        return ans;
    }
}
