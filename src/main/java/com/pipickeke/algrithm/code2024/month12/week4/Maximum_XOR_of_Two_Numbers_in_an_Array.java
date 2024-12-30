package com.pipickeke.algrithm.code2024.month12.week4;

/**
 * 题目：421. 数组中两个数的最大异或值
 * 标签：字典树
 *
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 */

public class Maximum_XOR_of_Two_Numbers_in_an_Array {

    public static void main(String[] args) {
        Maximum_XOR_of_Two_Numbers_in_an_Array bean = new Maximum_XOR_of_Two_Numbers_in_an_Array();
        int[] nums = {14,70,53,83,49,91,36,80,92,51,66,70};
        System.out.println(bean.findMaximumXOR(nums));
    }

    private int findMaximumXOR(int[] nums){
        int ans = 0;
        root = new Trie();

        for (int i = 1; i < nums.length; i++) {
            add(nums[i-1]);
            ans = Math.max(ans, get(nums[i]));
        }
        return ans;
    }

    private Trie root = null;
    private final int HIGH_BIT = 30;
    private void add(int x){
        Trie cur = root;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (x >> i) &1;
            if (cur.son[bit] == null){
                cur.son[bit] = new Trie();
            }
            cur = cur.son[bit];
        }
    }

    private int get(int x){
        Trie cur = root;
        int res = 0;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (x >> i) &1;
            if (cur.son[bit ^ 1] != null){
                res |= (1 << i);
                cur = cur.son[bit ^ 1];
            } else {
                cur = cur.son[bit];
            }
        }
        return res;
    }




    private class Trie{
        Trie[] son = null;

        public Trie() {
            son = new Trie[2];
        }
    }


}
