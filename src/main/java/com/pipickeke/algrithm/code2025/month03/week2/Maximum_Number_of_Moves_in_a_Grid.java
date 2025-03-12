package com.pipickeke.algrithm.code2025.month03.week2;

import java.util.Arrays;

/**
 * 题目：2684. 矩阵中移动的最大次数
 *
 * 给你一个下标从 0 开始、大小为 m x n 的矩阵 grid ，矩阵由若干 正 整数组成。
 *
 * 你可以从矩阵第一列中的 任一 单元格出发，按以下方式遍历 grid ：
 *
 * 从单元格 (row, col) 可以移动到 (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1) 三个单元格中任一满足值 严格 大于当前单元格的单元格。
 * 返回你在矩阵中能够 移动 的 最大 次数。
 *
 *
 */

public class Maximum_Number_of_Moves_in_a_Grid {


    private int maxMoves(int[][] grid){
        ans = 0;
        for (int i = 0; i < grid.length; i++) {
            dfs(i,0,grid);
        }
        return ans;
    }

    private int ans;

    private void dfs(int x, int y, int[][] grid){
        ans = Math.max(ans, y);
        if (ans == grid[0].length-1){
            return;
        }
        for (int k = Math.max(x-1,0); k < Math.min(x+2,grid.length); k++) {
            if (grid[k][y+1] > grid[x][y]){
                dfs(k, y+1, grid);
            }
        }
        grid[x][y] = 0;
    }
}
