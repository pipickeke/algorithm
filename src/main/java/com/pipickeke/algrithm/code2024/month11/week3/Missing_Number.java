package com.pipickeke.algrithm.code2024.month11.week3;

/**
 *  题目： 丢失的数字
 *  给定一个包含 [0, n] 中 n 个数的数组 nums ，
 *  找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class Missing_Number {

    public static void main(String[] args) {
        int[] arr = {3,0,1};
        System.out.println(miss(arr));
    }

    private static int miss(int[] nums){
        int N = nums.length;
        int tmp = 0;
        for (int i = 0; i <= N; i++) {
            tmp = tmp ^ i;
        }
        for (int i = 0; i < N; i++) {
            tmp = tmp ^ nums[i];
        }
        return tmp;
    }
}
