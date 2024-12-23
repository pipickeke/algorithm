package com.pipickeke.algrithm.code2024.month12.week3;


/**
 * 题目：1803. 统计异或值在范围内的数对有多少
 *
 * 给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数：low 和 high ，
 * 请返回 漂亮数对 的数目。
 *
 * 漂亮数对 是一个形如 (i, j) 的数对，其中 0 <= i < j < nums.length
 * 且 low <= (nums[i] XOR nums[j]) <= high 。
 *
 */
public class Count_Pairs_With_XOR_in_a_Range_3 {

    private int countPairs(int[] nums, int low, int high){
        return func(nums, high) - func(nums, low-1);
    }

    private final int HIGH_BIT = 14;
    private Trie root = null;
    private int func(int[] nums, int x){
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i-1]);
            ans += get(nums[i], x);
        }
        return ans;
    }

    private void add(int num){
        Trie cur = root;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int bit = (num >> k) &1;
            if (cur.son[bit] == null){
                cur.son[bit] = new Trie();
            }
            cur = cur.son[bit];
            cur.sum ++;
        }
    }

    private int get(int num, int x){
        Trie cur = root;
        int ans = 0;

        for (int k = HIGH_BIT; k >= 0; k--) {
            int bitnum = (num >> k) &1;
            int bitx = (x >> k) &1;

            if (bitx != 0){
                if (cur.son[bitnum] != null){
                    ans += cur.son[bitnum].sum;
                }
                if (cur.son[bitnum ^ 1] == null){
                    return ans;
                }
                cur = cur.son[bitnum ^ 1];
            } else {
                if (cur.son[bitnum] == null){
                    return ans;
                }
                cur = cur.son[bitnum];
            }
        }
        ans += cur.sum;
        return ans;
    }

    private class Trie{
        Trie[] son = new Trie[2];
        int sum;

        public Trie() {
            this.sum = 0;
        }
    }
}
