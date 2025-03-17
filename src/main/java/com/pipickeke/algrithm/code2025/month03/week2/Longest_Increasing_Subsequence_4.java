package com.pipickeke.algrithm.code2025.month03.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 300. 最长递增子序列
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 */

public class Longest_Increasing_Subsequence_4 {


    private int lengthOfLIS(int[] nums){
        int n = nums.length;
        int ans = 0;
        int[] memo = new int[n];
        for (int i = 0; i <n ; i++) {
            ans = Math.max(ans, dfs(i, nums, memo));
        }
        return ans;
    }

    private int dfs(int x, int[] nums, int[] memo){
        if (memo[x] != 0){
            return memo[x];
        }
        for (int y = 0; y < x; y++) {
            if (nums[y] < nums[x]){
                memo[x] = Math.max(memo[x], dfs(y, nums, memo));
            }
        }
        return ++memo[x];
    }



    private int lengthOfLIS_2(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            ans = Math.max(ans, ++dp[i]);
        }
        return ans;
    }


    private int lengthOfLIS_3(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : nums) {
            int y = lowbound(list, x);
            if (y == list.size()){
                list.add(x);
            } else {
                list.set(y, x);
            }
        }
        return list.size();
    }

    private int lowbound(List<Integer> list, int x){
        int left = 0;
        int right = list.size()-1;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (list.get(mid) < x){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

}
