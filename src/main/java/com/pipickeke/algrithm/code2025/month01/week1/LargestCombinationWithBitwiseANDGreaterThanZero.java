package com.pipickeke.algrithm.code2025.month01.week1;


/**
 * 题目：2275. 按位与结果大于零的最长组合
 *
 * 对数组 nums 执行 按位与 相当于对数组 nums 中的所有整数执行 按位与 。
 *
 * 例如，对 nums = [1, 5, 3] 来说，按位与等于 1 & 5 & 3 = 1 。
 * 同样，对 nums = [7] 而言，按位与等于 7 。
 * 给你一个正整数数组 candidates 。计算 candidates 中的数字每种组合下 按位与 的结果。
 *
 * 返回按位与结果大于 0 的 最长 组合的长度。
 *
 * 思路：
 *      数组nums[]中，任意子序列的按位与，大于0，这个结果值 AND >0
 *      可以发现， AND 中肯定至少有一位是1，有可能是最低位，也可能是其他位置
 *      可以从低位到高位枚举计算，判断 nums[] 每个数在二进制第i位，有多少个是1，
 *      取最大的数量，即可
 *
 */

public class LargestCombinationWithBitwiseANDGreaterThanZero {

    private int largestCombination(int[] candidates){
        int maxVal = 0;
        for (int i = 0; i < candidates.length; i++) {
            maxVal = Math.max(maxVal, candidates[i]);
        }

        int higBit = 32 - Integer.numberOfLeadingZeros(maxVal);
        int ans = 0;
        for (int i = 0; i < higBit; i++) {
            int cnt = 0;
            for (int j = 0; j < candidates.length; j++) {
                cnt += ((candidates[j] >> i) & 1);
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }


}
