package com.pipickeke.algrithm.code2024.month11.week4;

import java.util.Arrays;


/**
 *  题目： 只出现一次的数字 III
 *  给你一个整数数组 nums，其中恰好有两个元素只出现一次，
 *  其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *  你可以按 任意顺序 返回答案。
 *
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 */
public class Single_Number_III {

    public static void main(String[] args) {
        Single_Number_III bean = new Single_Number_III();
        int[] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(bean.singleNumber(nums)));
    }

    private int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int a = 0;
        int b = 0;
        int lowbit = xor == Integer.MIN_VALUE ? xor : (xor & (-xor));
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & lowbit) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[]{a, b};
    }

}
