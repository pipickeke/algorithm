package com.pipickeke.algrithm.code2025.month01.week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：746. 使用最小花费爬楼梯
 * 标签：动态规划
 *
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 */


public class Min_Cost_Climbing_Stairs {

    public static void main(String[] args) {
        Min_Cost_Climbing_Stairs bean = new Min_Cost_Climbing_Stairs();
        int[] cost = {10,15,20};
        System.out.println(bean.minCostClimbingStairs2(cost));
    }


    private int minCostClimbingStairs(int[] cost){
//        return Math.min(dfs(0,0,cost), dfs(1,0,cost));
        int n = cost.length;
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return dfs2(n, memo,cost);
    }

    /**
     * 超时
     * @param index
     * @param sum
     * @param cost
     * @return
     */
    private int dfs(int index, int sum,int[] cost){
        if (index >= cost.length){
            return sum;
        }
        return Math.min(dfs(index+1, sum+cost[index], cost),
                dfs(index+2, sum+cost[index], cost));
    }

    private int dfs2(int index, int[] memo, int[] cost){
        if (index <=1){
            return 0;
        }
        if (memo[index] != -1){
            return memo[index];
        }
        int res1 = dfs2(index-1, memo,cost) + cost[index-1];
        int res2 = dfs2(index-2, memo,cost) + cost[index-2];
        return memo[index] = Math.min(res1, res2);
    }


    private int minCostClimbingStairs2(int[] cost){
        int N = cost.length;
        int[] ans = new int[N+1];
        ans[0] = 0;
        ans[1] = 0;
        for (int i = 2; i <= N; i++) {
            ans[i] = Math.min(ans[i-1]+cost[i-1], ans[i-2] + cost[i-2]);
        }
        return ans[N];
    }

}
