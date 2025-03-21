package com.pipickeke.algrithm.code2025.month03.week3;

import java.util.Arrays;

/**
 *
 * 307. 区域和检索 - 数组可修改
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
 */

public class Range_Sum_Query_Mutable {

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9,10,11};
        NumArray_2 bean = new NumArray_2(nums);
        System.out.println(Arrays.toString(bean.tree));
        System.out.println(bean.sumRange(0,2));
        bean.update(1,2);
        System.out.println(bean.sumRange(0,2));
    }

}


class NumArray{
    int[] nums;
    int[] tree;

    public NumArray(int[] nums) {
        int n = nums.length;
        this.nums = new int[n];
        tree = new int[n+1];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val){
        int delta = val-nums[index];
        nums[index] = val;
        for (int i = index+1; i < tree.length; i += i&-i) {
            tree[i] += delta;
        }
    }

    public int prefixSum(int i){
        int s = 0;
        for (; i >0; i &= i-1){
            s += tree[i];
        }
        return s;
    }

    public int sumRange(int left, int right){
        return prefixSum(right+1) - prefixSum(left);
    }
}


class NumArray_2 {

    int[] nums;
    int[] tree;

    public NumArray_2(int[] nums) {
        int n = nums.length;
        this.nums = new int[n];
        this.tree = new int[n+1];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;
        for (int i = index+1; i < tree.length; i += i&-i) {
            tree[i] += delta;
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum(right+1) - prefixSum(left);
    }

    public int prefixSum(int x){
        int s = 0;
        for(; x > 0; x -= x&-x){
            s += tree[x];
        }
        return s;
    }

}























