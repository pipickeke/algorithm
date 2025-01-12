package com.pipickeke.algrithm.code2025.month01.week2;

import java.util.Arrays;

/**
 * 题目：233. 数字 1 的个数
 * 标签：数位DP
 *
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 */


public class Number_of_Digit_One {


    private int countDigitOne(int n){

        char[] strs = Integer.toString(n).toCharArray();
        int N = strs.length;
        int[][] memo = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(memo[i],-1);
        }
        return dfs(0,0,true,memo,strs);
    }

    private int dfs(int index, int cnt, boolean islimit, int[][] memo, char[] strs){
        if (index == strs.length){
            return cnt;
        }
        if (!islimit && memo[index][cnt] >= 0){
            return memo[index][cnt];
        }

        int ans = 0;
        int up = islimit ? strs[index] - '0' : 9;
        for (int d = 0; d <= up; d++) {
            ans += dfs(index+1, cnt + (d == 1 ? 1 : 0), islimit && d == up, memo, strs);
        }

        if (!islimit){
            memo[index][cnt] = ans;
        }
        return ans;
    }
}
