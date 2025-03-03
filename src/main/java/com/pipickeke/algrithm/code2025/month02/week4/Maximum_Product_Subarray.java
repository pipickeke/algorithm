package com.pipickeke.algrithm.code2025.month02.week4;

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

    public static void main(String[] args) {

        int[] largeArr = new int[100000];
        Arrays.setAll(largeArr, i -> i+1);

        long count = Arrays.stream(largeArr)
                .parallel() //使用并行流
                .filter(x -> x % 2 == 0)
                .count();

        System.out.println(count);
    }


    private int maxProduct(int[] nums){
        int n = nums.length;
        int[] fmax = new int[n];
        int[] fmin = new int[n];
        fmax[0] = fmin[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int x = nums[i];
            fmax[i] = Math.max(x, Math.max(fmax[i-1]*x, fmin[i-1]*x));
            fmin[i] = Math.min(x, Math.min(fmax[i-1]*x, fmin[i-1]*x));
        }
        return Arrays.stream(fmax).max().getAsInt();
    }


    private int maxProduct_2(int[] nums){
        int fmax = 1, fmin = 1, ans = Integer.MIN_VALUE;
        for (int x : nums) {
            int mx = fmax;
            fmax = Math.max(x, Math.max(fmax*x, fmin*x));
            fmin = Math.min(x, Math.min(mx*x, fmin*x));
            ans = Math.max(ans, fmax);
        }
        return ans;
    }
}
