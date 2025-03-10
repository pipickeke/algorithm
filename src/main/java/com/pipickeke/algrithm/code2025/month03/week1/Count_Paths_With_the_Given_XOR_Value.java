package com.pipickeke.algrithm.code2025.month03.week1;

import java.util.Arrays;
import java.util.Map;

/**
 * 题目：3393. 统计异或值为给定值的路径数目
 *
 * 给你一个大小为 m x n 的二维整数数组 grid 和一个整数 k 。
 *
 * 你的任务是统计满足以下 条件 且从左上格子 (0, 0) 出发到达右下格子 (m - 1, n - 1) 的路径数目：
 *
 * 每一步你可以向右或者向下走，也就是如果格子存在的话，
 * 可以从格子 (i, j) 走到格子 (i, j + 1) 或者格子 (i + 1, j) 。
 * 路径上经过的所有数字 XOR 异或值必须 等于 k 。
 * 请你返回满足上述条件的路径总数。
 *
 * 由于答案可能很大，请你将答案对 109 + 7 取余 后返回。
 *
 *
 */

public class Count_Paths_With_the_Given_XOR_Value {

    public static final int MOD = 1_000_000_007;

    private int countPathsWithXorValue(int[][] grid, int k){
        int mx = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mx = Math.max(mx, grid[i][j]);
            }
        }

        int bit = 1 << (32 - Integer.numberOfLeadingZeros(mx));
        if (k >= bit){
            return 0;
        }

        int[][][] memo = new int[m][n][bit];
        for (int[][] matrix : memo) {
            for (int[] row : matrix) {
                Arrays.fill(row,-1);
            }
        }
        return dfs(m-1,n-1,grid,k,memo);
    }

    private int dfs(int x, int y, int[][] grid, int k, int[][][] memo){
        if (x < 0 || y < 0){
            return 0;
        }
        if (x == 0 && y == 0){
            return grid[0][0] == k ? 1 : 0;
        }

        if (memo[x][y][k] != -1){
            return memo[x][y][k];
        }
        int left = dfs(x,y-1,grid,k^grid[x][y],memo);
        int right = dfs(x-1,y,grid,k^grid[x][y],memo);

        return memo[x][y][k] = (left+right) %MOD;
    }
    
    
    private int countPathsWithXorValue_2(int[][] grid, int k){
        int m = grid.length;
        int n = grid[0].length;
        int maxval = 0;
        for (int[] row : grid) {
            for (int x : row) {
                maxval = Math.max(maxval,x);
            }
        }

        int bit = 1 << (32 - Integer.numberOfLeadingZeros(maxval));
        if (k >= bit){
            return 0;
        }
        
        int[][][] dp = new int[m+1][n+1][bit];
        dp[0][1][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = grid[i][j];
                for (int num = 0; num < bit; num++) {
                    dp[i+1][j+1][num] = (dp[i][j+1][x ^ num] + dp[i+1][j][x ^ num]) %MOD;
                }
            }
        }
        return dp[m][n][k];
    }
    
}
