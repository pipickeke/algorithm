package com.pipickeke.algrithm.code2025.month01.week1;

/**
 * 题目：3153. 所有数对中数位差之和
 *
 * 你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。
 *
 * 两个整数的 数位差 指的是两个整数 相同 位置上不同数字的数目。
 *
 * 请你返回 nums 中 所有 整数对里，数位差之和。
 *
 */

public class Sum_of_Digit_Differences_of_All_Pairs {


    private long sumDigitDifferences(int[] nums){
        long ans = 0;
        int[][] cnt = new int[Integer.toString(nums[0]).length()][10];
        for (int k = 0; k < nums.length; k++) {
            int x = nums[k];

            for (int i = 0; x >0 ; x = x/10, i++) {
                ans += k - cnt[i][x%10]++;
            }
        }
        return ans;
    }

}
