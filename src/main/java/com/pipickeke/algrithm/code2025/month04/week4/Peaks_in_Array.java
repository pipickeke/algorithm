package com.pipickeke.algrithm.code2025.month04.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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

public class Peaks_in_Array {

    public List<Integer> countOfPeaks(int[] nums, int[][] queries){
        int N = nums.length;
        Fenwick_2 f = new Fenwick_2(N - 1);
        for (int i = 1; i < N - 1; i++) {
            update(f, nums, i, 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1){
                ans.add(f.query(query[1]+1, query[2]-1));
                continue;
            }
            int i = query[1];
            for (int j = Math.max(i-1, 1); j <= Math.min(i+1, N-2); j++) {
                update(f, nums, j, -1);
            }
            nums[i] = query[2];
            for (int j = Math.max(i-1, 1); j <= Math.min(i+1, N-2); j++) {
                update(f, nums, j, 1);
            }
        }
        return ans;
    }

    public void update(Fenwick_2 f, int[] num, int index, int val){
        if (num[index-1] < num[index] && num[index] > num[index+1]){
            f.update(index, val);
        }
    }
}

class Fenwick_2{

    int[] tree;

    public Fenwick_2(int n) {
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
