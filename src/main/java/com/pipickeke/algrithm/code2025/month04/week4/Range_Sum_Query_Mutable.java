package com.pipickeke.algrithm.code2025.month04.week4;

/**
 * 题目：307. 区域和检索 - 数组可修改
 *
 * 给你一个数组 nums ，请你完成两类查询。
 *
 * 其中一类查询要求 更新 数组 nums 下标对应的值
 * 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
 *
 *
 */

public class Range_Sum_Query_Mutable {


    class NumArray {

        int[] nums;
        int[] tree;

        public NumArray(int[] nums) {
            int N = nums.length;
            this.nums = new int[N];
            this.tree = new int[N+1];
            for (int i = 0; i < N; i++) {
                update(i, nums[i]);
            }
        }

        public void update(int index, int val) {
            int diff = val - this.nums[index];
            this.nums[index] = val;
            for (int i = index+1; i < this.tree.length; i += i&-i) {
                this.tree[i] += diff;
            }
        }

        public int sumRange(int left, int right) {
            return preSum(right+1) - preSum(left);
        }

        public int preSum(int index){
            int ans = 0;
            for (int i = index; i > 0; i -= i&-i) {
                ans += this.tree[i];
            }
            return ans;
        }
    }

}
