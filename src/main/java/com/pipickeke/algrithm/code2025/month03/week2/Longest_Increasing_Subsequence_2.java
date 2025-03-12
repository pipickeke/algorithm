package com.pipickeke.algrithm.code2025.month03.week2;


/**
 * 题目：300. 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 */

public class Longest_Increasing_Subsequence_2 {


    private int lengthOfLIS(int[] nums){
        int ans = 0;
        int n = nums.length;
        int[] memo = new int[n];

        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, dfs(i, nums, memo));
        }
        return ans;
    }

    private int dfs(int x, int[] nums, int[] memo){
        if (memo[x] != 0){
            return memo[x];
        }
        for (int j = 0; j < x; j++) {
            if (nums[j] < nums[x]){
                memo[x] = Math.max(memo[x], dfs(j, nums, memo));
            }
        }
        return ++memo[x];
    }
}
