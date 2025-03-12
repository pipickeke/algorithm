package com.pipickeke.algrithm.code2025.month03.week2;

import java.util.ArrayList;

/**
 * 题目：1573. 分割字符串的方案数
 *
 * 给你一个二进制串 s  （一个只包含 0 和 1 的字符串），我们可以将 s 分割成 3 个 非空 字符串 s1, s2, s3 （s1 + s2 + s3 = s）。
 *
 * 请你返回分割 s 的方案数，满足 s1，s2 和 s3 中字符 '1' 的数目相同。
 *
 * 由于答案可能很大，请将它对 10^9 + 7 取余后返回。
 *
 *
 */

public class NumberofWaystoSplitaString_2 {


    private int numWays(String s){
        int n = s.length();
        int MOD = 1_000_000_007;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1'){
                list.add(i);
            }
        }
        int cnt = list.size();
        if (cnt % 3 != 0){
            return 0;
        }
        if (cnt == 0){
            long ans = (long) (n - 1) * (n - 2) /2;
            return (int) (ans % MOD);
        } else {
            int idx1 = cnt/3;
            int idx2 = cnt/3 * 2;
            int cnt1 = list.get(idx1) - list.get(idx1 - 1);
            int cnt2 = list.get(idx2) - list.get(idx2 - 1);
            long ans = (long) cnt1 * cnt2;
            return (int) (ans % MOD);
        }
    }
}
