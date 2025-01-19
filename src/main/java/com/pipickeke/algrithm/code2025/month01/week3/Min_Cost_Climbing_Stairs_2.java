package com.pipickeke.algrithm.code2025.month01.week3;

import java.util.Arrays;

public class Min_Cost_Climbing_Stairs_2 {


    private int minCostClimbingStairs(int[] cost){
        return Math.min(dfs(0,0,cost),
                dfs(1,0,cost));
    }

    //超时
    private int dfs(int index, int sum,int[] cost){
        if (index >= cost.length){
            return sum;
        }
        return Math.min(dfs(index+1, sum+cost[index], cost),
                dfs(index+2, sum+cost[index], cost));
    }


    private int minCostClimbingStairs_2(int[] cost){
        int n = cost.length;
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return dfs_2(n,cost,memo);
    }

    private int dfs_2(int index, int[] cost, int[] memo){
        if (index < 2){
            return 0;
        }
        if (memo[index] != -1){
            return memo[index];
        }
        int ans = 0;
        ans = Math.min(dfs_2(index-1, cost, memo) + cost[index-1],
                dfs_2(index-2, cost, memo) + cost[index-2]);
        memo[index] = ans;
        return ans;
    }


    private int minCostClimbingStairs_3(int[] cost){
        int n = cost.length;
        int[] ans = new int[n+1];
        ans[0] = 0;
        ans[1] = 0;
        for (int i = 2; i < ans.length; i++) {
            ans[i] = Math.min(ans[i-1] + cost[i-1],
                    ans[i-2]+cost[i-2]);
        }
        return ans[n];
    }


}
