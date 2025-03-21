package com.pipickeke.algrithm.code2025.month03.week3;

import java.util.ArrayList;
import java.util.List;


/**
 * 题目：300. 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 */

public class Longest_Increasing_Subsequence {


    private int lengthOfLIS(int[] nums){
        int n = nums.length;
        int ans = 0;
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
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
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < x; y++) {
                if (nums[y] < nums[x]){
                    dp[x] = Math.max(dp[x], dp[y]);
                }
            }
            ans = Math.max(ans, ++dp[x]);
        }
        return ans;
    }

    private int lengthOfLIS_3(int[] nums){
        int n = nums.length;
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

    private int lowbound(List<Integer> list, int target){
        int left = 0;
        int right = list.size()-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (list.get(mid) < target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }


}
