package com.pipickeke.algrithm.code2025.month03.week1;

import java.util.Arrays;

/**
 * 题目：63. 不同路径 II
 *
 * 给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
 *
 * 返回机器人能够到达右下角的不同路径数量。
 *
 * 测试用例保证答案小于等于 2 * 109。
 *
 *
 */

public class Unique_Paths_II {


    private int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(obstacleGrid, m-1, n-1, memo);
    }

    private int dfs(int[][] grid, int x, int y, int[][] memo){
        if (x < 0 || y < 0){
            return 0;
        }
        if (grid[x][y] == 1){
            return 0;
        }
        if (x == 0 && y == 0){
            return 1;
        }
        if (memo[x][y] != -1){
            return memo[x][y];
        }

        return memo[x][y] = dfs(grid,x-1,y,memo) + dfs(grid,x,y-1,memo);
    }


    private int uniquePathsWithObstacles_2(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i+1][j+1] = obstacleGrid[i][j] == 0 ? (dp[i+1][j] + dp[i][j+1]) : 0;
            }
        }
        return dp[m][n];
    }



    private int uniquePathsWithObstacles_3(int[][] obstacleGrid){
        int n = obstacleGrid[0].length;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int[] row : obstacleGrid) {
            for (int i = 0; i < n; i++) {
                if (row[i] == 0){
                    dp[i+1] += dp[i];
                } else {
                    dp[i+1] = 0;
                }
            }
        }
        return dp[n];
    }

}
