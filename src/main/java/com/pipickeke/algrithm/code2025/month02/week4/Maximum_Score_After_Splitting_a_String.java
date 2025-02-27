package com.pipickeke.algrithm.code2025.month02.week4;

/**
 * 题目：1422. 分割字符串的最大得分
 *
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空
 * 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 *
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 *
 */

public class Maximum_Score_After_Splitting_a_String {

    public static void main(String[] args) {
        Maximum_Score_After_Splitting_a_String bean = new Maximum_Score_After_Splitting_a_String();
        String s = "011101";
        System.out.println(bean.maxScore(s));
    }

    private int maxScore(String s){
        int sum_1 = 0;
        for (int i = 0; i < s.length(); i++) {
            sum_1 += s.charAt(i) == '1' ? 1 : 0;
        }

        int[] memo = new int[2];
        int ans = 0;
        for (int i = 0; i < s.length()-1; i++) {
            memo[s.charAt(i)-'0']++;
            ans = Math.max(ans, memo[0] + (sum_1 - memo[1]));
        }
        return ans;
    }
}
