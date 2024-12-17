package com.pipickeke.algrithm.code2024.month12.week3;


/**
 * 题目：2997. 使数组异或和等于 K 的最少操作次数
 *
 * 给你一个下标从 0 开始的整数数组 nums 和一个正整数 k 。
 *
 * 你可以对数组执行以下操作 任意次 ：
 *
 * 选择数组里的 任意 一个元素，并将它的 二进制 表示 翻转 一个数位，翻转数位表示将 0 变成 1 或者将 1 变成 0 。
 * 你的目标是让数组里 所有 元素的按位异或和得到 k ，请你返回达成这一目标的 最少 操作次数。
 *
 * 注意，你也可以将一个数的前导 0 翻转。比方说，数字 (101)2 翻转第四个数位，得到 (1101)2 。
 */
public class MinimumNumberofOperationstoMakeArrayXOREqualtoK {

    public static void main(String[] args) {
        MinimumNumberofOperationstoMakeArrayXOREqualtoK bean = new MinimumNumberofOperationstoMakeArrayXOREqualtoK();
        int[] nums = {2,0,2,0};
        int k = 0;
        System.out.println(bean.minOperations(nums, k));
    }

    private int minOperations(int[] nums, int k){
        int xorsum = 0;
        for (int i = 0; i < nums.length; i++) {
            xorsum ^= nums[i];
        }

        int tmp = xorsum ^ k;
        int ans = 0;
        while (tmp != 0){
            ans += (tmp & 1) == 1 ? 1 : 0;
            tmp >>=1;
        }
        return ans;
    }
}
