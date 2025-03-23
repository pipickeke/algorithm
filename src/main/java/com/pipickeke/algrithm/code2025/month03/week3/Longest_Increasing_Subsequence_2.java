package com.pipickeke.algrithm.code2025.month03.week3;

import java.util.ArrayList;

public class Longest_Increasing_Subsequence_2 {

    private int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[] memo = new int[n];
        int ans = 0;
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
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = lowbond(list, nums[i]);
            if (j == list.size()){
                list.add(nums[i]);
            } else {
                list.set(j, nums[i]);
            }
        }
        return list.size();
    }

    private int lowbond(ArrayList<Integer> list, int target){
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
