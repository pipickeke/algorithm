package com.pipickeke.algrithm.code2025.month01.week2;

import java.util.Arrays;

/**
 * 题目：3022. 给定操作次数内使剩余元素的或值最小
 * 标签：试填法
 *
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 *
 * 一次操作中，你可以选择 nums 中满足 0 <= i < nums.length - 1 的一个下标 i ，
 * 并将 nums[i] 和 nums[i + 1] 替换为数字 nums[i] & nums[i + 1] ，其中 & 表示按位 AND 操作。
 *
 * 请你返回 至多 k 次操作以内，使 nums 中所有剩余元素按位 OR 结果的 最小值 。
 *
 */


public class Minimize_OR_of_Remaining_Elements_Using_Operations {

    public static void main(String[] args) {
        Minimize_OR_of_Remaining_Elements_Using_Operations bean = new Minimize_OR_of_Remaining_Elements_Using_Operations();
        int[] nums = {3,5,3,2,7};
        int k = 2;
        bean.minOrAfterOperations(nums, k);
    }


    private int minOrAfterOperations(int[] nums, int k){

        int ans = 0;
        int mask = 0;
        for (int i = 29; i >= 0; i--) {
            mask |= (1 << i);
            int cnt = 0;
            int and = -1;
            for (int j = 0; j < nums.length; j++) {
                and &= nums[j] & mask;
                if (and != 0){
                    cnt++;
                } else {
                    and = -1;
                }
            }
            if (cnt > k){
                ans |= (1 << i);
                mask ^= ( 1 << i);
            }
        }
        return ans;
    }
}






