package com.pipickeke.algrithm.code2025.month03.week1;

import java.util.Arrays;

/**
 * 题目：62. 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 */

public class Unique_Paths {

    private int uniquePaths(int m, int n){
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row,-1);
        }
        return dfs(m-1,n-1,memo);
    }

    private int dfs(int x, int y, int[][] memo){
        if (x < 0 || y < 0){
            return 0;
        }
        if (x == 0 && y == 0){
            return 1;
        }
        if (memo[x][y] != -1){
            return memo[x][y];
        }
        return memo[x][y] = dfs(x-1, y, memo) + dfs(x, y-1, memo);
    }


    private int uniquePaths_2(int m, int n){
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[m][n];
    }



}
