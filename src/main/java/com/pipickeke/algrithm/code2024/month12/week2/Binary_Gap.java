package com.pipickeke.algrithm.code2024.month12.week2;

import com.pipickeke.algrithm.code2024.month12.week1.Binary_Watch;


/**
 * 题目：二进制间距
 *
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。
 * 如果不存在两个相邻的 1，返回 0 。
 *
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。
 * 两个 1 之间的距离是它们的二进制表示中位置的绝对差。
 * 例如，"1001" 中的两个 1 的距离为 3 。
 *
 */
public class Binary_Gap {

    public static void main(String[] args) {
        Binary_Gap bean = new Binary_Gap();
        int n = 21;
        bean.print32Bit(n);
        System.out.println(bean.binaryGap(n));
    }

    private void print32Bit(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print( (num & 1<<i) == 0 ? "0" : "1" );
        }
        System.out.println();
    }

    private int binaryGap(int n){

        // 2的幂，只有1个1，
        if ( (n & (n-1)) == 0 ){
            return 0;
        }

        int ans1 = 0;
        int ans2 = 0;

        int lowBit = Integer.numberOfTrailingZeros(n);
        n >>= lowBit;
        while (n != 0){
            if ( (n & 1) == 1 ){
                ans1 = Math.max(ans1, ans2);
                ans2 = 0;
            }
            if ( (n & 1) == 0 ){
                ans2++;
            }
            n >>=1;
        }
        return ans1+1;
    }
}
