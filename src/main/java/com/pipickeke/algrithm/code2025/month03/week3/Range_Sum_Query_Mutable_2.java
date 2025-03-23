package com.pipickeke.algrithm.code2025.month03.week3;

public class Range_Sum_Query_Mutable_2 {

}

class NumArray_3{

    int[] nums;
    int[] tree;

    public NumArray_3(int[] nums) {
        int n = nums.length;
        tree = new int[n+1];
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        int delta = val - this.nums[index];
        this.nums[index] = val;
        for (int i = index+1; i < tree.length; i += i&-i) {
            tree[i] += delta;
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum(right+1) - prefixSum(left);
    }

    public int prefixSum(int index){
        int sum = 0;
        for (int i = index; i > 0; i -= i&-i) {
            sum += tree[i];
        }
        return sum;
    }

}
