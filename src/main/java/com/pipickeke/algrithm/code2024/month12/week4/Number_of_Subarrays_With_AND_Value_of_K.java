package com.pipickeke.algrithm.code2024.month12.week4;

/**
 * 题目：3209. 子数组按位与值为 K 的数目
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中有多少个
 * 子数组
 * 满足：子数组中所有元素按位 AND 的结果为 k 。
 *
 */

public class Number_of_Subarrays_With_AND_Value_of_K {


    private long countSubarrays(int[] nums, int k){

        int N = nums.length;
        long ans = 0L;
        int cnt = 0;
        for (int i = 0; i < N; i++) {

            int x = nums[i];
            cnt += x == k ? 1 : 0;
            for (int j = i-1; j >= 0 && (nums[j] & x) != nums[j]; j--) {
                cnt -= nums[j] == k ? 1 : 0;
                nums[j] &= x;
                cnt += nums[j] == k ? 1 : 0;
            }
            ans += cnt;
        }
        return ans;
    }
}
