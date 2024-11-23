package com.pipickeke.algrithm.code2024.month11.week3;

/**
 * 题目：只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，
 * 其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class Single_Number {

    public static void main(String[] args) {
        int[] arr = {2,2,1};
        System.out.println(single(arr));
    }

    private static int single(int[] nums){
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = cur ^ nums[i];
        }
        return cur;
    }
}
