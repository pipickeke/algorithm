package com.pipickeke.algrithm.code2025.month04.week4;

/**
 * 题目：1649. 通过指令创建有序数组
 *
 * 给你一个整数数组 instructions ，你需要根据 instructions 中的元素创建一个有序数组。一开始你有一个空的数组 nums ，你需要 从左到右 遍历 instructions 中的元素，将它们依次插入 nums 数组中。每一次插入操作的 代价 是以下两者的 较小值 ：
 *
 * nums 中 严格小于  instructions[i] 的数字数目。
 * nums 中 严格大于  instructions[i] 的数字数目。
 * 比方说，如果要将 3 插入到 nums = [1,2,3,5] ，那么插入操作的 代价 为 min(2, 1) (元素 1 和  2 小于 3 ，元素 5 大于 3 ），插入后 nums 变成 [1,2,3,3,5] 。
 *
 * 请你返回将 instructions 中所有元素依次插入 nums 后的 总最小代价 。由于答案会很大，请将它对 109 + 7 取余 后返回。
 *
 */

public class Create_Sorted_Array_through_Instructions {

    public int createSortedArray(int[] instructions){
        int MAX = 100_001;
        int MOD = 1_000_000_000;
        int N = instructions.length;
        Fenwick_6 f = new Fenwick_6(MAX);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int small = f.pre(instructions[i]-1);
            int big = i - f.pre(instructions[i]);
            ans += Math.min(small, big);
            ans %= MOD;
            f.add(instructions[i], 1);
        }
        return ans;
    }
}

class Fenwick_6{
    int[] tree;

    public Fenwick_6(int n) {
        this.tree = new int[n];
    }

    public void add(int index, int val){
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
}
