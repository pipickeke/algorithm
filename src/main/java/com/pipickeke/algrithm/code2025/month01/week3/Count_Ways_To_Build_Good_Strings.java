package com.pipickeke.algrithm.code2025.month01.week3;

import java.util.Arrays;
import java.util.Map;

/**
 * 题目：2466. 统计构造好字符串的方案数
 * 标签：递归、记忆化搜索
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

public class Count_Ways_To_Build_Good_Strings {


    public static void main(String[] args) {
        Count_Ways_To_Build_Good_Strings bean = new Count_Ways_To_Build_Good_Strings();
        int low = 2;
        int high = 3;
        int zero = 1;
        int one = 2;
//        System.out.println(bean.countGoodStrings(low, high, zero, one));
        System.out.println(bean.countGoodStrings_2(low, high, zero, one));
    }


    //超时
    private int countGoodStrings(int low, int high, int zero, int one) {
        StringBuilder str0 = new StringBuilder();
        StringBuilder str1 = new StringBuilder();
        for (int i = 1; i <= zero; i++) {
            str0.append('0');
        }
        for (int i = 1; i <= one; i++) {
            str1.append('1');
        }

        mask0 = str0.toString();
        mask1 = str1.toString();
        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans += dfs(new StringBuilder(), i);
        }
        return (int) (ans % (Math.pow(10,9)+7));
    }

    private String mask1;
    private String mask0;

    private int dfs(StringBuilder sb, int N) {
        if (sb.length() == N) {
            return 1;
        }
        if (sb.length() > N) {
            return 0;
        }
        int ans = 0;
        int res0 = dfs(sb.append(mask0), N);
        sb.setLength(sb.length() - mask0.length());
        int res1 = dfs(sb.append(mask1), N);
        sb.setLength(sb.length() - mask1.length());
        ans = res0 + res1;
        return ans;
    }



    private int countGoodStrings_2(int low, int high, int zero, int one) {
        StringBuilder str0 = new StringBuilder();
        StringBuilder str1 = new StringBuilder();
        for (int i = 1; i <= zero; i++) {
            str0.append('0');
        }
        for (int i = 1; i <= one; i++) {
            str1.append('1');
        }

        mask0 = str0.toString();
        mask1 = str1.toString();

        int[] memo = new int[high+1];

        int ans = 0;
        for (int i = low; i <= high; i++) {
            Arrays.fill(memo,-1);
            ans += dfs_2(new StringBuilder(), i, memo);
        }
        return ans;
    }

    private int dfs_2(StringBuilder sb, int N, int[] memo) {
        if (sb.length() == N) {
            return 1;
        }
        if (sb.length() > N) {
            return 0;
        }
        if (memo[sb.length()] != -1) {
            return memo[sb.length()];
        }
        int res0 = dfs_2(sb.append(mask0), N, memo);
        sb.setLength(sb.length() - mask0.length());
        int res1 = dfs_2(sb.append(mask1), N, memo);
        sb.setLength(sb.length() - mask1.length());
        memo[sb.length()] = res0 + res1;
        return res0+res1;
    }



    private  int countGoodStrings_3(int low, int high, int zero, int one){
        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans += dfs_3(0, i, zero, one);
        }
        return ans;
    }

    private int dfs_3(int len, int N, int zero, int one){
        if (len == N){
            return 1;
        }
        if (len > N){
            return 0;
        }
        int res0 = dfs_3(len+zero, N, zero, one);
        int res1 = dfs_3(len+one, N, zero, one);
        return res0+res1;
    }



    private int countGoodStrings_4(int low, int high, int zero, int one){
        int ans = 0;
        int[] memo = new int[high+1];
        Arrays.fill(memo,-1);
        for (int i = low; i <= high; i++) {
            ans = (ans + dfs_4(i, zero, one, memo)) % MOD;
        }
        return ans;
    }

    private static final int MOD = 1000000007;

    private int dfs_4(int n, int zero, int one, int[] memo){
        if (n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }
        if (memo[n] != -1){
            return memo[n];
        }
        return memo[n] = (dfs_4(n-zero, zero, one, memo) +
                dfs_4(n-one, zero, one, memo)) % MOD;
    }



}
