package com.pipickeke.algrithm.code2025.month01.week3;

import java.util.Arrays;

/**
 * 题目：377. 组合总和 Ⅳ
 * 标签：动态规划
 *
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
 * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 *
 */


public class Combination_Sum_IV {

    public static void main(String[] args) {
        Combination_Sum_IV bean = new Combination_Sum_IV();
        int[] nums = {1,2,3};
        int target = 4;
        System.out.println(bean.combinationSum4(nums, target));
    }

    private int combinationSum4(int[] nums, int target){
        int[] memo = new int[target+1];
        Arrays.fill(memo,-1);
        return dfs(target, nums, memo);
    }

    private int dfs(int target, int[] nums, int[] memo){
        if (target == 0){
            return 1;
        }
        if (memo[target] != -1){
            return memo[target];
        }
        int ans = 0;
        for (int x : nums) {
            if (x <= target){
                ans += dfs(target-x, nums, memo);
            }
        }
        memo[target] = ans;
        return ans;
    }



    private int combinationSum4_2(int[] nums, int target){
        int[] ans = new int[target+1];
        ans[0] = 1;
        for (int i = 1; i < ans.length; i++) {
            for (int x : nums) {
                if (x <= i){
                    ans[i] += ans[i-x];
                }
            }
        }
        return ans[target];
    }

}
