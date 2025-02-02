package com.pipickeke.algrithm.code2025.month01.week4;

import java.util.Arrays;

/**
 * 题目：213. 打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，
 * 今晚能够偷窃到的最高金额。
 *
 */

public class HouseRobberII {

    private int rob(int[] nums){

        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo,-1);
        return dfs(n-1, nums, memo);
    }


    private int dfs(int index, int[] nums, int[] memo){
        if (index == 0){
            return nums[0];
        }
        if (index < 0){
            return 0;
        }
        if (memo[index] != -1){
            return memo[index];
        }
        return memo[index] = Math.max(dfs(index-1, nums, memo),
                dfs(index-2,nums,memo) + nums[index]);

    }

    private int rob_2(int[] nums){
        int n = nums.length;
        int[] dp = new int[n+2];
        for (int i = 0; i < n; i++) {
            dp[i+2] = Math.max(dp[i+1], dp[i] + nums[i]);
        }
        return dp[n+1];
    }

    private int rob_3(int[] nums){
        int n = nums.length;
        return Math.max(func(2, n-1, nums) + nums[0],
                func(1, n, nums));
    }

    private int func(int start, int end, int[] nums){
        int f0 = 0;
        int f1 = 0;
        for (int i = start; i < end; i++) {
            int tmp = Math.max(f1, f0+nums[i]);
            f0 = f1;
            f1 = tmp;
        }
        return f1;
    }



}
