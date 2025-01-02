package com.pipickeke.algrithm.code2025.month01.week1;

/**
 * 题目：3171. 找到按位或最接近 K 的子数组
 * 标签：Logtrick
 *
 * 给你一个数组 nums 和一个整数 k 。你需要找到 nums 的一个
 * 子数组
 *  ，满足子数组中所有元素按位或运算 OR 的值与 k 的 绝对差 尽可能 小 。
 *  换言之，你需要选择一个子数组 nums[l..r] 满足 |k - (nums[l] OR nums[l + 1] ... OR nums[r])| 最小。
 *
 * 请你返回 最小 的绝对差值。
 *
 * 子数组 是数组中连续的 非空 元素序列。
 *
 */

public class Find_Subarray_With_Bitwise_OR_Closest_to_K {

    public static void main(String[] args) {

    }

    private int minimumDifference(int[] nums, int k){

        int ans = Integer.MAX_VALUE;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int x = nums[i];

            ans = Math.min(ans, Math.abs(x - k));
            for (int j = i-1; j >= 0 && (nums[j] | x) != nums[j]; j--) {
                nums[j] |= x;
                ans = Math.min(ans, Math.abs(nums[j] - k));
            }
        }
        return ans;
    }
}
