package com.pipickeke.algrithm.code2025.month03.week1;

import java.util.Arrays;
import java.util.List;

/**
 * 题目：120. 三角形最小路径和
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标
 * 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，
 * 那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 */

public class Triangle {


    private int minimumTotal(List<List<Integer>> triangle){
        int n = triangle.size();
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs(0,0,triangle,memo);
    }

    private int dfs(int x, int y, List<List<Integer>> triangle, int[][] memo){
        if (x == triangle.size()-1){
            return triangle.get(x).get(y);
        }
        if (memo[x][y] != Integer.MIN_VALUE){
            return memo[x][y];
        }
        return memo[x][y] = triangle.get(x).get(y) + Math.min(dfs(x+1,y,triangle,memo),
                dfs(x+1,y+1,triangle,memo));
    }


    private int minimumTotal_2(List<List<Integer>> triangle){
        int n = triangle.size();

        int[][] dp = new int[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = triangle.get(i).size()-1; j >= 0; j--) {
                if (i == n-1){
                    dp[i][j] = triangle.get(n-1).get(j);
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }





}












