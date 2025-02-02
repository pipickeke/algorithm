package com.pipickeke.algrithm.code2025.month01.week4;

import java.util.Arrays;

/**
 * 题目：198. 打家劫舍
 * 标签：DP
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 */

public class House_Robber {

    private int rob(int[] nums){
        int N = nums.length;
        int[] memo = new int[N];
        Arrays.fill(memo,-1);
        return dfs(nums.length-1, nums,memo);
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

        return memo[index] = Math.max(dfs(index-1,nums,memo),
                dfs(index-2,nums,memo)+nums[index]);
    }



    private int rob_2(int[] nums){
        int N = nums.length;
        int[] dp = new int[N+2];
        for (int i = 0; i < N; i++) {
            dp[i+2] = Math.max(dp[i+1], dp[i]+nums[i]);
        }
        return dp[N+1];
    }

}




