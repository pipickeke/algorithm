package com.pipickeke.algrithm.code2025.month01.week3;

import java.util.Arrays;

/**
 * 题目：2466. 统计构造好字符串的方案数
 *
 * 给你整数 zero ，one ，low 和 high ，我们从空字符串开始构造一个字符串，
 * 每一步执行下面操作中的一种：
 *
 * 将 '0' 在字符串末尾添加 zero  次。
 * 将 '1' 在字符串末尾添加 one 次。
 * 以上操作可以执行任意次。
 *
 * 如果通过以上过程得到一个 长度 在 low 和 high 之间（包含上下边界）的字符串，
 * 那么这个字符串我们称为 好 字符串。
 *
 * 请你返回满足以上要求的 不同 好字符串数目。由于答案可能很大，请将结果对 109 + 7 取余 后返回。
 *
 */

public class Count_Ways_To_Build_Good_Strings_3 {


    private int countGoodStrings(int low, int high, int zero, int one){
        int ans = 0;
        int[] memo = new int[high+1];
        Arrays.fill(memo, -1);
        for (int i = low; i <= high; i++) {
            ans = (ans + dfs(i, zero, one, memo)) %MOD;
        }
        return ans;
    }

    private static final int MOD = 1000000007;
    private int dfs(int n, int zero, int one, int[] memo){
        if (n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }
        if (memo[n] != -1){
            return memo[n];
        }
        return memo[n] = ( dfs(n-zero, zero, one, memo) +
                dfs(n - one, zero, one, memo)) %MOD;
    }
}
