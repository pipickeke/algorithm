package com.pipickeke.algrithm.code2025.month01.week3;

import com.sun.org.apache.bcel.internal.generic.RET;


/**
 * 题目：2266. 统计打字方案数
 * 标签：分组+数位DP
 *
 * Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
 *
 * 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
 *
 * 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
 * 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
 * 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
 *
 * 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
 * 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
 *
 * 由于答案可能很大，将它对 109 + 7 取余 后返回。
 *
 */

public class Count_Number_of_Texts {


    private int countTexts(String pressedKeys){
        long ans = 1;
        int cnt = 0;
        for (int i = 0; i < pressedKeys.length(); i++) {
            char ch = pressedKeys.charAt(i);
            cnt++;
            if (i == pressedKeys.length()-1 || ch != pressedKeys.charAt(i+1)){
                ans = ans * (ch != '7' && ch != '9' ? f[cnt] : g[cnt]) %MOD;
                cnt = 0;
            }
        }
        return (int) ans;
    }

    private static final int MOD = 1000000007;
    private static final int MX = 100001;
    private static final long[] f = new long[MX];
    private static final long[] g = new long[MX];

    static {
        f[0] = g[0] = 1;
        f[1] = g[1] = 1;
        f[2] = g[2] = 2;
        f[3] = g[3] = 4;
        for (int i = 4; i < MX; i++) {
            f[i] = (f[i-1] + f[i-2] + f[i-3]) %MOD;
            g[i] = (g[i-1] + g[i-2] + g[i-3] + g[i-4]) %MOD;
        }

    }

}
