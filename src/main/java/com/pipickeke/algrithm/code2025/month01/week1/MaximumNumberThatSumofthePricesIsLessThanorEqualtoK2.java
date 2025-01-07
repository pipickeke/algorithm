package com.pipickeke.algrithm.code2025.month01.week1;

import java.util.Arrays;

/**
 * 题目：3007. 价值和小于等于 K 的最大数字
 * 标签：二分查找+数位DP
 *
 * 给你一个整数 k 和一个整数 x 。整数 num 的价值是它的二进制表示中在 x，2x，3x 等位置处
 * 设置位
 *  的数目（从最低有效位开始）。下面的表格包含了如何计算价值的例子。
 *
 * x	num	Binary Representation	Price
 * 1	13	000001101	3
 * 2	13	000001101	1
 * 2	233	011101001	3
 * 3	13	000001101	1
 * 3	362	101101010	2
 *
 *
 * num 的 累加价值 是从 1 到 num 的数字的 总 价值。如果 num 的累加价值小于或等于 k 则被认为是 廉价 的。
 *
 * 请你返回 最大 的廉价数字。
 *
 *
 */

public class MaximumNumberThatSumofthePricesIsLessThanorEqualtoK2 {

    private long findMaximumNumber(long k, int x){

        this.x = x;

        long left = 0;
        long right = (k+1) << x;
        while (left+1 < right){
            long mid = (left+right) >>1;
            if (countBitOne(mid) <= k){
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int x;
    private long num;
    private long[][] memo;
    private long countBitOne(long num){
        int highBit = 64 - Long.numberOfLeadingZeros(num);
        this.num = num;

        memo = new long[highBit][highBit+1];
        for (int i = 0; i < highBit; i++) {
            Arrays.fill(memo[i],-1);
        }

        return dfs(highBit-1,0,true);
    }

    private long dfs(int index, int cnt, boolean islimit){
        if (index < 0){
            return cnt;
        }
        if (!islimit && memo[index][cnt] != -1){
            return memo[index][cnt];
        }

        long res = 0;
        int up = islimit ? (int) (num >> index & 1) : 1;
        for (int d = 0; d <= up; d++) {
            res += dfs(index-1, cnt + (d == 1 && (index+1)%x == 0 ? 1 : 0), islimit && d == up);
        }

        if (!islimit){
            memo[index][cnt] = res;
        }
        return res;
    }
}
