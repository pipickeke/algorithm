package com.pipickeke.algrithm.code2025.month04.week3;

public class Range_Sum_Query_Mutable_2 {


    class NumArray {

        int[] nums;
        int[] tree;

        public NumArray(int[] nums) {
            int n = nums.length;
            this.nums = new int[n];
            this.tree = new int[n+1];
            for (int i = 0; i < n; i++) {
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
            return presum(right+1) - presum(left);
        }

        public int presum(int index){
            int ans = 0;
            for (int i = index; i > 0; i -= i&-i) {
                ans += this.tree[i];
            }
            return ans;
        }
    }

}
