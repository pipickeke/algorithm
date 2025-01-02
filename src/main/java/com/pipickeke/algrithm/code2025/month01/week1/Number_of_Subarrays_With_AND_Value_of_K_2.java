package com.pipickeke.algrithm.code2025.month01.week1;

/**
 * 题目：3209. 子数组按位与值为 K 的数目
 * 标签：二分查找、Logtrick
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中有多少个
 * 子数组
 * 满足：子数组中所有元素按位 AND 的结果为 k 。
 *
 */

public class Number_of_Subarrays_With_AND_Value_of_K_2 {


    private long countSubarrays(int[] nums, int k){

        long ans = 0;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int x = nums[i];

            for (int j = i-1; j >= 0 && (nums[j] & x) != nums[j]; j--) {
                nums[j] &= x;
            }
            //因为 [left,right) 是  num[j]=k的范围，且这个范围是非降序的，可以利用二分
            //找出 区间 [j,i) 中 第一个大于等于K的坐标，和第一个大于等于k+1的坐标
            // 二者之差就是 k 的个数
            ans += lowbount(nums, i+1,k+1) - lowbount(nums,i+1,k);
        }
        return ans;
    }

    private int lowbount(int[] nums, int right, int target){
        int left = -1;
        while (left + 1 < right){
            int mid = left + (right-left)/2;
            if (nums[mid] >= target){
                right=mid;
            } else {
                left=mid;
            }
        }
        return right;
    }
}
