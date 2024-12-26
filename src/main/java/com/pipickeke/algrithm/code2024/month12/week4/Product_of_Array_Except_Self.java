package com.pipickeke.algrithm.code2024.month12.week4;

import java.util.Arrays;

/**
 * 题目：238. 除自身以外数组的乘积
 * 标签：前缀和
 *
 * 给你一个整数数组 nums，返回 数组 answer ，
 * 其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 */

public class Product_of_Array_Except_Self {

    public static void main(String[] args) {
        Product_of_Array_Except_Self bean = new Product_of_Array_Except_Self();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(bean.productExceptSelf(nums)));
    }

    private int[] productExceptSelf(int[] nums){

        int N = nums.length;
        int[] right = new int[N];
        right[N-1] = 1;
        for (int i = N-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        int[] left = new int[N];
        left[0] = 1;
        for (int i = 1; i < N; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}
