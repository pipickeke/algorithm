package com.pipickeke.algrithm.code2025.month03.week1;

import java.util.Arrays;

/**
 * 题目：64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 */

public class Minimum_Path_Sum {

    private int minPathSum(int[][] grid){

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][1] = 0;
        for (int i = 0; i < n; i++) {
            dp[i+1][0] = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                dp[i+1][j+1] = Math.min(dp[i][j+1], dp[i+1][j]) + grid[i][j];
            }
        }
        return dp[n][m];
    }


    private int minPathSum_2(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(grid, n-1, m-1, memo);
    }

    private int dfs(int[][] grid, int x, int y, int[][] memo){
        if (x < 0 || y < 0){
            return Integer.MAX_VALUE;
        }
        if (x == 0 && y == 0){
            return grid[0][0];
        }
        if (memo[x][y] != -1){
            return memo[x][y];
        }
        return memo[x][y] = Math.min(dfs(grid,x-1,y, memo), dfs(grid,x,y-1, memo)) + grid[x][y];
    }



}