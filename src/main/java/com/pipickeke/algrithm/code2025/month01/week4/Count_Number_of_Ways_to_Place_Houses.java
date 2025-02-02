package com.pipickeke.algrithm.code2025.month01.week4;

import java.util.Arrays;

/**
 * 题目：2320. 统计放置房子的方式数
 *
 * 一条街道上共有 n * 2 个 地块 ，街道的两侧各有 n 个地块。每一边的地块都按从 1 到 n 编号。
 * 每个地块上都可以放置一所房子。
 *
 * 现要求街道同一侧不能存在两所房子相邻的情况，请你计算并返回放置房屋的方式数目。
 * 由于答案可能很大，需要对 109 + 7 取余后再返回。
 *
 * 注意，如果一所房子放置在这条街某一侧上的第 i 个地块，不影响在另一侧的第 i 个地块放置房子。
 *
 */

public class Count_Number_of_Ways_to_Place_Houses {

    public static void main(String[] args) {
        Count_Number_of_Ways_to_Place_Houses bean = new Count_Number_of_Ways_to_Place_Houses();
        System.out.println(bean.countHousePlacements(2));
    }


    private int countHousePlacements(int n){
        long[] memo = new long[n+1];
        Arrays.fill(memo,-1);
        return (int) Math.pow(dfs(n-1, n, memo),2);
    }

    private static final int MOD = 1000000007;
    private long dfs(int index, int N, long[] memo){
        if (index == 0){
            return 2;
        }
        if (index < 0){
            return 1;
        }
        if (memo[index] != -1){
            return memo[index];
        }
        return memo[index] = (dfs(index-1,N,memo) + dfs(index-2,N, memo)) %MOD;
    }

    private int countHousePlacements_2(int n){
        return (int) ((long) f[n] * f[n]) %MOD;
    }

    private static final int MX = 10000;
    private static final int[] f = new int[MX];
    static {
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < MX; i++) {
            f[i] = (f[i-1] + f[i-2]) %MOD;
        }
    }

}
