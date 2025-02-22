package com.pipickeke.algrithm.code2025.month02.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：1177. 构建回文串检测
 *
 * 给你一个字符串 s，请你对 s 的子串进行检测。
 *
 * 每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。我们可以 重新排列
 * 子串 s[left], ..., s[right]，并从中选择 最多 k 项替换成任何小写英文字母。
 *
 * 如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。
 *
 * 返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。
 *
 * 注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，也就是说，如果
 * s[left..right] = "aaa" 且 k = 2，我们只能替换其中的两个字母。（另外，
 * 任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）
 *
 *
 */

public class Can_Make_Palindrome_from_Substring {

    public static void main(String[] args) {
        Can_Make_Palindrome_from_Substring bean = new Can_Make_Palindrome_from_Substring();
        String s = "abcda";

    }

    private List<Boolean> canMakePaliQueries(String s, int[][] queries){
        int n = s.length();
        int[][] matrix = new int[n+1][26];
        for (int i = 0; i < s.length(); i++) {
            matrix[i+1] = matrix[i];
            matrix[i+1][s.charAt(i)-'a']++;
        }

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int sum = 0;
            //统计[l,r]范围内，每个字母出现奇数的个数和
            for (int j = 0; j < 26; j++) {
                sum += (matrix[r][j] - matrix[l][j]) %2;
            }
            //如果出现奇数次的字母个数和sum，sum/2 比 k小
            //则可以通过变换，实现回文字符串
            ans.add(sum/2 <= k);
        }
        return ans;
    }
}
