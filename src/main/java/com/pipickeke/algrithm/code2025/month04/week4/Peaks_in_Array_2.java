package com.pipickeke.algrithm.code2025.month04.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：3187. 数组中的峰值
 *
 * 数组 arr 中 大于 前面和后面相邻元素的元素被称为 峰值 元素。
 *
 * 给你一个整数数组 nums 和一个二维整数数组 queries 。
 *
 * 你需要处理以下两种类型的操作：
 *
 * queries[i] = [1, li, ri] ，求出子数组 nums[li..ri] 中 峰值 元素的数目。
 * queries[i] = [2, indexi, vali] ，将 nums[indexi] 变为 vali 。
 * 请你返回一个数组 answer ，它依次包含每一个第一种操作的答案。
 *
 * 注意：
 *
 * 子数组中 第一个 和 最后一个 元素都 不是 峰值元素。
 *
 */

public class Peaks_in_Array_2 {

    public List<Integer> countOfPeaks(int[] nums, int[][] queries){
        int N = nums.length;
        Fenwick_3 f = new Fenwick_3(N - 1);
        for (int i = 1; i < N - 1; i++) {
            update(f, nums, i, 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1){
                ans.add(f.query(q[1]+1, q[2]-1));
                continue;
            }
            int index = q[1];
            for (int j = Math.max(index-1,1); j <= Math.min(index+1, N-2); j++) {
                update(f, nums, j, -1);
            }
            nums[index] = q[2];
            for (int j = Math.max(index-1,1); j <= Math.min(index+1, N-2); j++) {
                update(f, nums, j, 1);
            }
        }
        return ans;
    }

    public void update(Fenwick_3 f, int[] nums, int index,int val){
        if (nums[index-1] < nums[index] && nums[index] > nums[index+1]){
            f.update(index,val);
        }
    }

}

class Fenwick_3{
    int[] tree;

    public Fenwick_3(int n) {
        this.tree = new int[n];
    }

    public void update(int index, int val){
        for (int i = index; i < this.tree.length; i += i&-i) {
            this.tree[i] += val;
        }
    }

    public int pre(int index){
        int ans = 0;
        for (int i = index; i > 0; i -= i&-i) {
            ans += this.tree[i];
        }
        return ans;
    }

    public int query(int left, int right){
        if (right < left){
            return 0;
        }
        return pre(right) - pre(left-1);
    }
}
