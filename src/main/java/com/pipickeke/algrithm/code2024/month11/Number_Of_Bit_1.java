package com.pipickeke.algrithm.code2024.month11;

/**
 *  题目：位1的个数
 *  力扣：https://leetcode.cn/problems/number-of-1-bits/submissions/582325251/
 *  思路：
 *
 *  时间：2024-11-22
 */
public class Number_Of_Bit_1 {

    public static void main(String[] args) {
        int num = 3;
        System.out.println(bit(num));
    }

    private static int bit(int num){
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            ans += (num & (1 << i)) == 0 ? 0 : 1;
        }
        return ans;
    }
}
