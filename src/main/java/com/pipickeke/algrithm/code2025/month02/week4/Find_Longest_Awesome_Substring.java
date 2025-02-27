package com.pipickeke.algrithm.code2025.month02.week4;

import java.util.Arrays;

/**
 * 题目：1542. 找出最长的超赞子字符串
 *
 * 给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。
 *
 * 「超赞子字符串」需满足满足下述两个条件：
 *
 * 该字符串是 s 的一个非空子字符串
 * 进行任意次数的字符交换后，该字符串可以变成一个回文字符串
 *
 *
 */

public class Find_Longest_Awesome_Substring {


    private int longestAwesome(String s){
        final int CNT = 10;

        int n = s.length();
        int[] pos = new int[1 << CNT];
        Arrays.fill(pos, n);
        pos[0] = -1;

        int pre = 0, ans = 0;
        //固定到位置i，去找j，使得子串 s[j,i] 是最长的回文串
        for (int i = 0; i < n; i++) {
            pre ^= 1 << (s.charAt(i)-'0');
            for (int j = 0; j < CNT ; j++) {
                // pre[i] ^ pre[j] = 2^k
                // 此时只有一个数字出现奇数，其他都是偶数，也可以实现回文串
                // 找到 pre[j] = pre[i] ^ 2^k
                //筛选最长的子串即可
                ans = Math.max(ans, i - pos[pre ^ (1 << j)]);
            }
            //此时判断是所有数字都出现偶数
            // pre[i] ^ pre[j] = 0
            // 则 pre[j] = pre[i]
            ans = Math.max(ans, i - pos[pre]);
            if (pos[pre] == n){
                pos[pre] = i;
            }
        }
        return ans;
    }


    private int longestAwesome_2(String s){
        // 0 ~ 9 一共10种字符
        final int NUMS = 10;
        int n = s.length();
        int[] pos = new int[1 << NUMS];
        Arrays.fill(pos, n);
        pos[0] = -1;

        int pre = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            pre ^= 1 << (s.charAt(i) - '0');
            for (int j = 0; j < NUMS; j++) {
                ans = Math.max(ans, i - pos[pre ^ (1 << j)]);
            }
            ans = Math.max(ans, i - pos[pre]);
            if (pos[pre] == n){
                pos[pre] = i;
            }
        }
        return ans;
    }
}
