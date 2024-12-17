package com.pipickeke.algrithm.code2024.month12.week3;

import java.util.Arrays;


/**
 * 题目：每个查询的最大异或值
 *
 * 给你一个 有序 数组 nums ，它由 n 个非负整数组成，同时给你一个整数 maximumBit 。
 * 你需要执行以下查询 n 次：
 *
 * 找到一个非负整数 k < 2maximumBit ，使得 nums[0] XOR nums[1] XOR ...
 * XOR nums[nums.length-1] XOR k 的结果 最大化 。k 是第 i 个查询的答案。
 * 从当前数组 nums 删除 最后 一个元素。
 * 请你返回一个数组 answer ，其中 answer[i]是第 i 个查询的结果。
 *
 */
public class Maximum_XOR_for_Each_Query {

    public static void main(String[] args) {
        Maximum_XOR_for_Each_Query bean = new Maximum_XOR_for_Each_Query();
        int[] nums = {2,3,4,7};
        int maximumBit = 3;
        System.out.println(Arrays.toString(bean.getMaximumXor(nums, maximumBit)));
    }

    private int[] getMaximumXor(int[] nums, int maximumBit){

        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int maxBit = (1 << maximumBit)-1;
        int[] ans = new int[nums.length];
        for (int i = nums.length-1; i >= 0; i--) {

            ans[nums.length-1-i] = xor ^ maxBit;
            xor ^= nums[i];
        }
        return ans;
    }
}
