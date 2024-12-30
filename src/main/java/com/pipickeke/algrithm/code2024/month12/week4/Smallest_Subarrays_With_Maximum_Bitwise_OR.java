package com.pipickeke.algrithm.code2024.month12.week4;


/**
 * 题目：2411. 按位或最大的最小子数组长度
 * 标签：Logtrick
 *
 * 给你一个长度为 n 下标从 0 开始的数组 nums ，数组中所有数字均为非负整数。
 * 对于 0 到 n - 1 之间的每一个下标 i ，你需要找出 nums 中一个 最小 非空子数组，它的起始位置为 i （包含这个位置），同时有 最大 的 按位或运算值 。
 *
 * 换言之，令 Bij 表示子数组 nums[i...j] 的按位或运算的结果，你需要找到一个起始位置为 i
 * 的最小子数组，这个子数组的按位或运算的结果等于 max(Bik) ，其中 i <= k <= n - 1 。
 * 一个数组的按位或运算值是这个数组里所有数字按位或运算的结果。
 *
 * 请你返回一个大小为 n 的整数数组 answer，其中 answer[i]是开始位置为 i ，
 * 按位或运算结果最大，且 最短 子数组的长度。
 *
 * 子数组 是数组里一段连续非空元素组成的序列。
 *
 * 思路：
 *      （1）此类题目需要先想出暴力方法，即 o(n^2)，也就是两层循环
 *          外层i，从 [0,N-1] 遍历 nums[]
 *          对于每个i, 都从  j:  i-1 > 0 开始遍历，
 *          每次都进行 累计或运算  num[j] |= x
 *          效果就是 ans[j] => 子数组 [j,i] 的累计或运算和
 *          因为要求最大的或运算和，且最短子数组长度，
 *          只有当  num[j] < num[j] | x，才更新 res[j] = i-j+1
 *
 */
public class Smallest_Subarrays_With_Maximum_Bitwise_OR {

    private int[] smallestSubarrays(int[] nums){
        
        int N = nums.length;
        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {

            ans[i] = 1;
            int x = nums[i];
            for (int j = i-1; j >= 0 && (nums[j] | x) != nums[j]; j--) {
                int tmp = nums[j];
                nums[j] |= x;
                ans[j] = tmp < nums[j] ? i-j+1 : ans[j];
            }
        }
        return ans;
    }
}
