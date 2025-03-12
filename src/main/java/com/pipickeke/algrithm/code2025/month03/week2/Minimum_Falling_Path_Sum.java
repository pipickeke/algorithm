package com.pipickeke.algrithm.code2025.month03.week2;

import java.util.Arrays;


/**
 * 题目：931. 下降路径最小和
 *
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 *
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 */

public class Minimum_Falling_Path_Sum {


    private int minFallingPathSum(int[][] matrix){
        int n = matrix.length;
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dfs(0,i,matrix,memo));
        }
        return ans;
    }

    private int dfs(int x, int y, int[][] matrix, int[][] memo){
        if (y < 0 || y >= matrix.length){
            return Integer.MAX_VALUE;
        }
        if (x == matrix.length-1){
            return matrix[x][y];
        }
        if (memo[x][y] != Integer.MIN_VALUE){
            return memo[x][y];
        }
        int leftdown = dfs(x+1,y-1,matrix,memo);
        int dow = dfs(x+1,y,matrix,memo);
        int rightdown = dfs(x+1,y+1,matrix,memo);
        return memo[x][y] = matrix[x][y] + Math.min(dow, Math.min(leftdown, rightdown));
    }


    private int minFallingPathSum_2(int[][] matrix){
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i == n-1){
                    dp[i][j] = matrix[i][j];
                } else {
                    int leftdown = j-1 < 0 ? Integer.MAX_VALUE : dp[i+1][j-1];
                    int rightdown = j+1 >= n ? Integer.MAX_VALUE : dp[i+1][j+1];
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], Math.min(leftdown,rightdown));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[0][i]);
        }
        return ans;
    }
}
